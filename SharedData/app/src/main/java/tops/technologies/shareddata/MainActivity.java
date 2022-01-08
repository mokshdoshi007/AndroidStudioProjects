package tops.technologies.shareddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{
    private final String sharedpreffile="sharedPref";
    EditText e1,e2,e3;
    TextInputLayout textInputLayout;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        textInputLayout = findViewById(R.id.nameinput);

        name = e1.getText().toString();

        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        if (preferences.getBoolean("session", true) && !preferences.getString("data", "").isEmpty())
        {
            Intent loginmove = new Intent(MainActivity.this, Dashboard.class);
            startActivity(loginmove);
        }
    }

    public void login(View view) {

        if(name.isEmpty())
        {
            textInputLayout.setError("Enter the Name");
        }

        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        String datainsert = "Name: "+e1.getText().toString()+"\n"+"Email: "+e2.getText().toString()+"\n"+"Password: "+e3.getText().toString();
        editor.putString("data",datainsert);
        editor.putBoolean("session",true);
        editor.commit();
        Intent loginmove = new Intent(MainActivity.this, Dashboard.class);
        startActivity(loginmove);
    }
}