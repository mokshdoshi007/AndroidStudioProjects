package tops.technologies.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    TextInputEditText email, password;
    TextView newuser;
    String e,p,sharedpreffile="data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        newuser=findViewById(R.id.newuser);
        newuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(Login.this, register.class);
                startActivity(registermove);
            }
        });
    }

    public void loginclick(View view) {
        e=email.getText().toString();
        p=password.getText().toString();
        if(e.isEmpty()) {
            email.setError("Enter the Email");
            return;
        }
        if(p.isEmpty()) {
            password.setError("Enter the Password");
            return;
        }
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("email",e);
        editor.putString("password",p);
        editor.commit();
        Intent loginmove = new Intent(Login.this, MainActivity.class);
        startActivity(loginmove);

    }
}