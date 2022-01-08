package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button login;

    TextView sign;
    Button log;
    TextView forgotpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgotpass = findViewById(R.id.forgotpassword);
        forgotpass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(registermove);
            }
        });

        log=findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginmove = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(loginmove);
            }
        });

        sign=findViewById(R.id.signup);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signupmove = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(signupmove);
            }
        });
    }
}