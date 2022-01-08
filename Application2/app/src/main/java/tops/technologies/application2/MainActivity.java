package tops.technologies.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText demo;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        send=findViewById(R.id.b1);
        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent secondmove = new Intent(MainActivity.this, SecondActivity.class);
                onclicks();
                startActivity(secondmove);
            }
        });
    }

    private void init() {
        demo=findViewById(R.id.et);
    }

    private void onclicks() {
        String data = demo.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("xyz",data);
        startActivity(intent);
    }

}