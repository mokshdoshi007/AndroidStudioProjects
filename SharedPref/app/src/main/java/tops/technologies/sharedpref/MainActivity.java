package tops.technologies.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.SocketHandler;

public class MainActivity extends AppCompatActivity {

    EditText input;
    private final String sharedpreffile="sharedPref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.tv);
    }

    public void read(View view)
    {
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        input.setText(preferences.getString("data","Not Found"));
        Toast.makeText(MainActivity.this,"Read Complete", Toast.LENGTH_SHORT).show();
    }

    public void write(View view) {
        String datainsert = input.getText().toString();
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data",datainsert);
        editor.commit();
        input.setText("");
        Toast.makeText(MainActivity.this,"Data Stored", Toast.LENGTH_SHORT).show();
    }
}