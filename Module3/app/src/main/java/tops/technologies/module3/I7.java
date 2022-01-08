package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class I7 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i7);
        textView = findViewById(R.id.tv2);
    }

    public void hide(View view) {
        if (textView.getVisibility() == View.VISIBLE)
            textView.setVisibility(View.INVISIBLE);
    }

    public void show(View view) {
        if (textView.getVisibility() == View.INVISIBLE)
            textView.setVisibility(View.VISIBLE);
    }
}