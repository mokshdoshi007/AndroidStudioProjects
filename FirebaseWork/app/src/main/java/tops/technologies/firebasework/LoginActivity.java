package tops.technologies.firebasework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email,password;
    String e,p;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        firebaseAuth = FirebaseAuth.getInstance();
    }
    public void registermove(View view) {
        Intent registermove = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(registermove);
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

                Intent intent = new Intent(LoginActivity.this, Dashboard.class);
                startActivity(intent);
                }).addOnFailureListener(e -> {
                    Toast.makeText(this, "Wrong Email / Password", Toast.LENGTH_SHORT).show();
                });


        }
    }

}
