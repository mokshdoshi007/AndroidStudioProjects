package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class I2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i2);
    }

    public void subi2(View view) {
        EditText editText2 = findViewById(R.id.et2);
        EditText editText3 = findViewById(R.id.et3);
        Intent intent = new Intent(I2.this,subi2.class);
        intent.putExtra("num1",editText2.getText().toString());
        intent.putExtra("num2",editText3.getText().toString());
        startActivity(intent);
    }
}