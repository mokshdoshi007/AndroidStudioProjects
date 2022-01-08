package tops.technologies.sqlexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import tops.technologies.sqlexample.Adapter.UserRecyclerAdapter;
import tops.technologies.sqlexample.Model.User;
import tops.technologies.sqlexample.SQL.DatabaseHelper;

public class ListActivity extends AppCompatActivity {

    private TextView textView;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UserRecyclerAdapter userRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        recyclerViewUsers=findViewById(R.id.rv);
        textView=findViewById(R.id.nm);

        listUsers=new ArrayList<>();
        userRecyclerAdapter = new UserRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(layoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(userRecyclerAdapter);
        databaseHelper=new DatabaseHelper(this);

        getDatafromSQLite();
    }

    private void getDatafromSQLite() {

        new AsyncTask<Void,Void,Void>()
        {
            @Override
            protected Void doInBackground(Void... voids) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getallusers());
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                userRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}