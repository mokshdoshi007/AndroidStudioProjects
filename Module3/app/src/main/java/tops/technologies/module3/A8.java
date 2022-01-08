package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class A8 extends AppCompatActivity {
    RadioGroup radioGroup;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a8);
        radioGroup=findViewById(R.id.rg2);
        ll=findViewById(R.id.ll3);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                String x = radioButton.getText().toString();
                if(x.equalsIgnoreCase("red"))
                    ll.setBackgroundResource(R.color.red);
                else if(x.equalsIgnoreCase("blue"))
                    ll.setBackgroundResource(R.color.blue);
                else if(x.equalsIgnoreCase("green"))
                    ll.setBackgroundResource(R.color.green);
            }
        });
    }
}