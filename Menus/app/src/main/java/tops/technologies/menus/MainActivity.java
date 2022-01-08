package tops.technologies.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void B3(View view) {startActivity(new Intent(MainActivity.this,B3.class));   }

    public void A3(View view) {startActivity(new Intent(MainActivity.this,A3.class));}
}