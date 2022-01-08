package tops.technologies.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextInputEditText email,password;
    RadioGroup radioGroup;
    String e,p;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        radioGroup=findViewById(R.id.radiogroup);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void patientregister(View view) {
        Intent intent = new Intent(MainActivity.this, UserRegistration.class);
        startActivity(intent);
        finish();
    }
    public void doctorregister(View view) {
        Intent intent = new Intent(MainActivity.this, DoctorRegistration.class);
        startActivity(intent);
        finish();
    }
    public void login(View view) {
        e=email.getText().toString();
        p=password.getText().toString();
        if (e.isEmpty())
            email.setError("Enter Email");
        else if (p.isEmpty())
            password.setError("Enter Password");
        else
        {
            firebaseAuth.signInWithEmailAndPassword(e,p).addOnSuccessListener(authResult -> {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                System.out.println(radioButton.getText());
                if (radioButton.getText().equals("Patient"))
                {
                    Intent intent = new Intent(MainActivity.this, UserDashboard.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, DoctorDashboard.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(e -> {
                Toast.makeText(this, "Wrong Email / Password", Toast.LENGTH_SHORT).show();
            });


        }
    }
}