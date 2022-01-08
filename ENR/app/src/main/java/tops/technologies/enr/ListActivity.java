package tops.technologies.enr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    static int total;
    static int cid;
    private TextView textView;
    private RecyclerView recyclerViewUsers;
    private List<User> users;
    private List<Products> productsList,productsListcopy;
    private UserRecyclerAdapter userRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerViewUsers=findViewById(R.id.rv);
        textView=findViewById(R.id.nm);
        textView.setText("Cart ID: "+intent.getStringExtra("cid"));
        cid= Integer.parseInt(intent.getStringExtra("cid"));
        users= new ArrayList<>();
        productsList = new ArrayList<>();
        productsListcopy = new ArrayList<>();
        getDatafromFirebase();
    }

    private void getDatafromFirebase() {
        FirebaseFirestore mFirebaseFirestore = FirebaseFirestore.getInstance();
        mFirebaseFirestore.collection("Barcodes").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty())
                {
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot d: list)
                    {
                        User u = d.toObject(User.class);
                        users.add(u);
                    }
                }
                mFirebaseFirestore.collection("Products").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(!queryDocumentSnapshots.isEmpty())
                        {
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for(DocumentSnapshot d: list)
                            {
                                Products p = d.toObject(Products.class);
                                productsList.add(p);
                            }
                        }
                        for(int i=0; i<users.size(); i++)
                        {
                            if(users.get(i).getCartID()==cid)
                            {
                                long x = users.get(i).getBarcode();
                                for(int j=0; j<productsList.size(); j++)
                                {
                                    if(productsList.get(j).getBarcode()==x)
                                    {
                                        productsListcopy.add(productsList.get(j));
                                    }
                                }
                            }
                        }
                        userRecyclerAdapter = new UserRecyclerAdapter(productsListcopy);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerViewUsers.setLayoutManager(layoutManager);
                        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
                        recyclerViewUsers.setHasFixedSize(true);
                        recyclerViewUsers.setAdapter(userRecyclerAdapter);
                    }

                });
            }
        }).addOnFailureListener(e -> {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        });
        }


    public void makepayment(View view) {
        Intent intent = new Intent(ListActivity.this, Payment.class);
        intent.putExtra("total",total);
        startActivity(intent);
        total=0;
        finish();
    }
}