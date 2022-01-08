package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class I1 extends AppCompatActivity {
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i1);

        editText=findViewById(R.id.et1);
        textView=findViewById(R.id.tv1);
        editText.addTextChangedListener(new TextWatcher()
        {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            int x = Integer.parseInt(s.toString());
            int y=0;
            while (x!=0) {
                y = y * 10 + x % 10;
                x /= 10;
            }
            textView.setText(String.valueOf(y));
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {        }
        @Override
        public void afterTextChanged(Editable s) {        }
        });
    }
}