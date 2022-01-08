package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class A4 extends AppCompatActivity {
    LinearLayout ll2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a4);
        ll2 = findViewById(R.id.ll2);
        editText = findViewById(R.id.et6);
    }

    public void create(View view) {
        try {
            ll2.removeAllViews();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        int length = Integer.parseInt(editText.getText().toString());

        for (int i = 0; i < length; ++i) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT);

            EditText et = new EditText(this);
            et.setId(i);
            et.setHint("EditText - "+(i+1));
            et.setLayoutParams(params);
            ll2.addView(et);
        }
    }
}
