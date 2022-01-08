package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class A2 extends AppCompatActivity {
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        linearLayout=findViewById(R.id.ll);
    }

    public void red(View view) { linearLayout.setBackgroundResource(R.color.red); }

    public void blue(View view) {
        linearLayout.setBackgroundResource(R.color.blue);
    }

    public void green(View view) {
        linearLayout.setBackgroundResource(R.color.green);
    }
}