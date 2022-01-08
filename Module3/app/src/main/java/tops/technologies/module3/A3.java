package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class A3 extends AppCompatActivity {
    TextView textView;
    int textsize=15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
        textView=findViewById(R.id.tv4);
    }

    public void plus(View view) {
        textView.setTextSize(++textsize);
    }

    public void minus(View view) {
        textView.setTextSize(--textsize);
    }
}