package tops.technologies.sqlexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import tops.technologies.sqlexample.Model.User;
import tops.technologies.sqlexample.SQL.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email,password;
    String e,p;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        databaseHelper=new DatabaseHelper(this);
    }

    public void registermove(View view) {
        Intent registermove = new Intent(LoginActivity.this, RegisterActivity.class);
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
            if(databaseHelper.checkuser(e,p)) {
                Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Wrong Email / Password", Toast.LENGTH_SHORT).show();
        }
    }


}