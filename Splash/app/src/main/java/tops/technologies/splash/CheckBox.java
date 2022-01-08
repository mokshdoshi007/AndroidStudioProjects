package tops.technologies.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBox extends AppCompatActivity {
    android.widget.CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        c1=findViewById(R.id.one);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(CheckBox.this, "Checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBox.this, "Unchecked", Toast.LENGTH_SHORT).show();
            }
        });
    }

}