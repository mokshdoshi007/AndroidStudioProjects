package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class basic_signup extends AppCompatActivity {
    Button signup;
    TextView olduser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_signup);
        signup=findViewById(R.id.signup);
        olduser=findViewById(R.id.olduser);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(basic_signup.this, Dashboard.class);
                startActivity(registermove);
            }
        });
        olduser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent registermove = new Intent(basic_signup.this, LoginActivity.class);
                startActivity(registermove);
            }
        });
    }
}