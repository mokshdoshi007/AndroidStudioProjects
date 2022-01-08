package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class A5 extends AppCompatActivity {
    TextView textView;
    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a5);
        textView = findViewById(R.id.tv5);
        checkBox=findViewById(R.id.showhide);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked)
                textView.setVisibility(View.VISIBLE);
            else
                textView.setVisibility(View.INVISIBLE);
        });

    }
}