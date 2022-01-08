package tops.technologies.sharedpref2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password;
    private final String file = "data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
    }

    public void store(View view) {
        SharedPreferences preferences = getSharedPreferences(file, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",name.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.commit();
        name.setText("");
        email.setText("");
        password.setText("");
        Toast.makeText(MainActivity.this,"Data Stored",Toast.LENGTH_SHORT).show();
    }

    public void read(View view) {
        SharedPreferences preferences = getSharedPreferences(file, MODE_PRIVATE);
        name.setText(preferences.getString("name","Not Found"));
        email.setText(preferences.getString("email","Not Found"));
        password.setText(preferences.getString("password","Not Found"));
        Toast.makeText(MainActivity.this,"Read Done",Toast.LENGTH_SHORT).show();
    }
}