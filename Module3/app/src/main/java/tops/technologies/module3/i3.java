package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class i3 extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView textView;
    EditText et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i3);
        radioGroup=findViewById(R.id.rg);
        textView=findViewById(R.id.result2);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                String x = radioButton.getText().toString();
                String a1 = et4.getText().toString();
                String b1 = et5.getText().toString();
                int a =Integer.parseInt(a1);
                int b =Integer.parseInt(b1);
                if(x.equalsIgnoreCase("Add"))
                {
                    textView.setText(String.valueOf(a+b));
                }
                else if(x.equalsIgnoreCase("Subtraction"))
                    textView.setText(String.valueOf(a-b));
                else if(x.equalsIgnoreCase("Multiply"))
                    textView.setText(String.valueOf(a*b));
                else if(x.equalsIgnoreCase("Division"))
                    textView.setText(String.valueOf(a/b));
            }
        });
    }
}