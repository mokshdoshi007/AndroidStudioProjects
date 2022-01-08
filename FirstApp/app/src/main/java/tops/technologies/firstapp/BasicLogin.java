package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasicLogin extends AppCompatActivity {

    Button login;
    TextView forgotpass,newuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_login);
        login=findViewById(R.id.login);
        forgotpass=findViewById(R.id.forgotpassword);
        newuser=findViewById(R.id.newuser);

       forgotpass.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Intent registermove = new Intent(BasicLogin.this, ForgotPassword.class);
            startActivity(registermove);
        }
    });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(BasicLogin.this, Dashboard.class);
                startActivity(registermove);
            }
        });
        newuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(BasicLogin.this, basic_signup.class);
                startActivity(registermove);
            }
        });
}
}