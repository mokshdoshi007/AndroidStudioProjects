package tops.technologies.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import tops.technologies.project.model.Doctor;
import tops.technologies.project.model.Person;

public class DoctorRegistration extends AppCompatActivity {
    TextInputEditText name,email,password,cpassword,category,hname,haddress;
    String n,p,cp,e,c,hn,ha;
    RadioGroup radioGroup;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);
            name=findViewById(R.id.name);
            email=findViewById(R.id.email);
            password=findViewById(R.id.password);
            cpassword=findViewById(R.id.cpassword);
            category=findViewById(R.id.category);
            hname=findViewById(R.id.hname);
            haddress=findViewById(R.id.haddress);
            radioGroup=findViewById(R.id.radiogroup);
            firebaseAuth=FirebaseAuth.getInstance();
            firebaseDatabase=FirebaseDatabase.getInstance();
            databaseReference=firebaseDatabase.getReference("Doctors");
        }
        public void loginmove(View view) {
            Intent loginmove = new Intent(DoctorRegistration.this, MainActivity.class);
            startActivity(loginmove);
            finish();
        }
        public void register(View view) {
            n=name.getText().toString();
            e=email.getText().toString();
            p=password.getText().toString();
            cp=cpassword.getText().toString();
            c=category.getText().toString();
            hn=hname.getText().toString();
            ha=haddress.getText().toString();
            if (n.isEmpty())
                name.setError("Enter Name");
            else if (e.isEmpty())
                email.setError("Enter Email");
            else if (c.isEmpty())
                category.setError("Enter Category");
            else if (hn.isEmpty())
                hname.setError("Enter Hospital Name");
            else if (ha.isEmpty())
                haddress.setError("Enter Hospital Address");
            else if (p.isEmpty())
                password.setError("Enter Password");
            else if (cp.isEmpty())
                cpassword.setError("Enter Confirm Password");
            else if (!p.equals(cp))
                password.setError("Password don't match");
            else {
                firebaseAuth.createUserWithEmailAndPassword(e,p).addOnSuccessListener(command -> {
                    String g = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                    Doctor doctor = new Doctor(n,e,g,c,hn,ha,p);
                    String id = UUID.randomUUID().toString();
                    databaseReference.child(id).setValue(doctor);
                    Intent intent = new Intent(DoctorRegistration.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(DoctorRegistration.this, "Account Created", Toast.LENGTH_SHORT).show();
                });
                    //   Doctor doctor = new Doctor(n,e,radioButton.getText().toString(),c,hn,ha,p);
            }
        }
    }