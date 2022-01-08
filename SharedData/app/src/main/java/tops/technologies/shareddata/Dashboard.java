package tops.technologies.shareddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    TextView tv;
    private final String sharedpreffile="sharedPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tv=findViewById(R.id.tv);
        read();
    }
    public void read()
    {
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        tv.setText(preferences.getString("data","Not Found"));
    }

    public void logout(View view) {
        SharedPreferences preferences = getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        preferences.edit().clear().commit();
        Intent logoutmove = new Intent(Dashboard.this, MainActivity.class);
        startActivity(logoutmove);
        finish();
    }
}