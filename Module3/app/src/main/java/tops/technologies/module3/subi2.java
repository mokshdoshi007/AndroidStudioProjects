package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class subi2 extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subi2);
        textView=findViewById(R.id.result);
        Intent intent = getIntent();
        String  x1 = intent.getStringExtra("num1");
        String y1 = intent.getStringExtra("num2");
        Log.e("num1",x1+y1);
        int x = Integer.valueOf(x1);
        int y = Integer.valueOf(y1);
        String m ="";
        for(int i=x; i<=y; i++)
            m=m+i+" ";
        textView.setText(m);
    }
}