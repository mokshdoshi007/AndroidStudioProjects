package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class A_I1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a__i1);

        TextView textView = findViewById(R.id.tv6);
        List <String> cities = new ArrayList<String>();
        cities.add("Ahmedabad");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Chennai");
        cities.add("Kolkata");
        ArrayAdapter userAdapter = new ArrayAdapter(this, R.layout.spinner, cities);

        Spinner userSpinner = findViewById(R.id.cities);
        userSpinner.setAdapter(userAdapter);
        userSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String x = (String) parent.getSelectedItem();
                textView.setText(x);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}