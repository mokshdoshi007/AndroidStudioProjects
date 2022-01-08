package tops.technologies.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {
    EditText e,e1,e2,e3;
    Button sbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        sbut=findViewById(R.id.sbut);
        sbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent signupmove = new Intent(RegisterActivity.this, MainActivity.class);
                onclicks();
                //startActivity(signupmove);
            }
        });
    }
    private void init() {

        e=findViewById(R.id.e);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
    }

    private void onclicks() {
        String et = e.getText().toString();
        String et1 = e1.getText().toString();
        String et2 = e2.getText().toString();
        String et3 = e3.getText().toString();
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("et",et);
        intent.putExtra("et1",et1);
        intent.putExtra("et2",et2);
        intent.putExtra("et3",et3);
        startActivity(intent);
    }
}