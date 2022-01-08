package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv,tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        String r = getIntent().getStringExtra("et");
        String r1 = getIntent().getStringExtra("et1");
        String r2 = getIntent().getStringExtra("et2");
        String r3 = getIntent().getStringExtra("et3");
        Log.d("message",r);
        tv.setText(r);
        tv1.setText(r1);
        tv2.setText(r2);
        tv3.setText(r3);
    }

    private void init() {
        tv=findViewById(R.id.tv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
    }
}