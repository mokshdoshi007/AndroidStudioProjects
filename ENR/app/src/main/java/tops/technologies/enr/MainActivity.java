package tops.technologies.enr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText cid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cid=findViewById(R.id.cid);
    }

    public void viewcart(View view) {
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        intent.putExtra("cid",cid.getText().toString());
        startActivity(intent);
    }
}