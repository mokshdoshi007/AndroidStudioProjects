package tops.technologies.menus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_city);
    }

    public void update(View view) {
        Intent intent = getIntent();
        EditText editText = findViewById(R.id.et);
        String x = editText.getText().toString();
        B3.cities.set(intent.getIntExtra("index",0),x);
        B3.adapter.notifyDataSetChanged();
        finish();
    }
}