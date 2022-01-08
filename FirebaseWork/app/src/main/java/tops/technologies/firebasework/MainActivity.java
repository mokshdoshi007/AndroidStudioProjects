package tops.technologies.firebasework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    TextInputEditText name,email,password,cpassword;
    String n,e,p,cp;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users");
    }
    public void loginmove(View view) {
        Intent loginmove = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginmove);
    }
    public void register(View view) {
        n=name.getText().toString();
        e=email.getText().toString();
        p=password.getText().toString();
        cp=cpassword.getText().toString();
        if (n.isEmpty())
            name.setError("Enter Name");
        if (e.isEmpty())
            email.setError("Enter Email");
        else if (p.isEmpty())
            password.setError("Enter Password");
        else if (cp.isEmpty())
            cpassword.setError("Enter Confirm Password");
        else if (!p.equals(cp))
            password.setError("Password don't match");
        else {
            firebaseAuth.createUserWithEmailAndPassword(e,p).addOnSuccessListener(authResult ->
            {
                Person person = new Person(n,e,p);
                String id = UUID.randomUUID().toString();
                databaseReference.child(id).setValue(person);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                SharedPreferences preferences = getSharedPreferences("file", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("id",id);
                editor.commit();
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
            });
        }
    }
}