package tops.technologies.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import tops.technologies.project.model.Person;

public class UserRegistration extends AppCompatActivity {
    TextInputEditText name,email,password,cpassword,age;
    RadioGroup radioGroup;
    String n,e,p,cp,a;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        age=findViewById(R.id.age);
        radioGroup=findViewById(R.id.radiogroup);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Users");
    }
    public void loginmove(View view) {
        Intent loginmove = new Intent(UserRegistration.this, MainActivity.class);
        startActivity(loginmove);
        finish();
    }
    public void register(View view) {
        n=name.getText().toString();
        e=email.getText().toString();
        p=password.getText().toString();
        cp=cpassword.getText().toString();
        a=age.getText().toString();
        if (n.isEmpty())
            name.setError("Enter Name");
        else if (e.isEmpty())
            email.setError("Enter Email");
        else if (a.isEmpty())
            age.setError("Enter Age");
        else if (p.isEmpty())
            password.setError("Enter Password");
        else if (cp.isEmpty())
            cpassword.setError("Enter Confirm Password");
        else if (!p.equals(cp))
            password.setError("Password don't match");
        else {
            firebaseAuth.createUserWithEmailAndPassword(e,p).addOnSuccessListener(authResult ->
            {
                String g = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                Person person = new Person(n,e,g,a,p);
                String id = UUID.randomUUID().toString();
                databaseReference.child(id).setValue(person);
                Intent intent = new Intent(UserRegistration.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(UserRegistration.this, "Account Created", Toast.LENGTH_SHORT).show();
            });
        }
    }


}