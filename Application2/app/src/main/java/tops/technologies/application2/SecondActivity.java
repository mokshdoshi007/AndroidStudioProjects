package tops.technologies.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView result;
    Button send2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        String recieve = getIntent().getStringExtra("xyz");
        //System.out.println(recieve);
        Log.d("message",recieve);
        result.setText(recieve);
        send2=findViewById(R.id.b2);
        send2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent firstmove = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(firstmove);
            }
        });
    }

    private void init() {
        result=findViewById(R.id.st);
    }
}