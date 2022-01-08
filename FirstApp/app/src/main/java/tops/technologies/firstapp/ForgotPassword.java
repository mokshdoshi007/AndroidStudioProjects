
package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ForgotPassword extends AppCompatActivity {
    Button sendotp;
    TextView rememberpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        sendotp=findViewById(R.id.sendotp);
        rememberpass=findViewById(R.id.rememberpassword);

        sendotp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(ForgotPassword.this, Dashboard.class);
                startActivity(registermove);
            }
        });
        rememberpass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(ForgotPassword.this, BasicLogin.class);
                startActivity(registermove);
            }
        });
    }
}