package tops.technologies.sqlexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import tops.technologies.sqlexample.Model.User;
import tops.technologies.sqlexample.SQL.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText name,email,password,cpassword;
    String n,e,p,cp;
    private User user;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        cpassword=findViewById(R.id.cpassword);
        databaseHelper = new DatabaseHelper(this);
        user = new User();
    }
    public void loginmove(View view) {
        Intent loginmove = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(loginmove);
    }
    public void register(View view) {
        n=name.getText().toString();
        e=email.getText().toString();
        p=password.getText().toString();
        cp=cpassword.getText().toString();
        if (n.isEmpty())
            name.setError("Enter Name");
        if (e.isEmpty())
            email.setError("Enter Email");
        else if (p.isEmpty())
            password.setError("Enter Password");
        else if (cp.isEmpty())
            cpassword.setError("Enter Confirm Password");
        else if (!p.equals(cp))
            password.setError("Password don't match");
        else {
            user.setName(n);
            user.setEmail(e);
            user.setPassword(p);
            databaseHelper.addUser(user);
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}