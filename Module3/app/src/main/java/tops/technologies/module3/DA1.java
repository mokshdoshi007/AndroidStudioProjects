package tops.technologies.module3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DA1 extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da1);
        tv=findViewById(R.id.tv8);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        String[] cities = new String[]{
                "Ahmedabad", "Mumbai", "Delhi", "Chennai", "Kolkata"};
        final boolean[] checkedCities = new boolean[]{
                false, false, false, false, false};

        final List<String> citieslist = Arrays.asList(cities);
        builder.setMultiChoiceItems(cities, checkedCities, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedCities[which] = isChecked;
                String currentItem = citieslist.get(which);
                Toast.makeText(getApplicationContext(), currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(false);
        builder.setTitle("Your preferred cities?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click positive button
                tv.setText("Your preferred cities are \n");
                for (int i = 0; i < checkedCities.length; i++) {
                    boolean checked = checkedCities[i];
                    if (checked) {
                        tv.setText(tv.getText() + cities[i] + " ");
                    }
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}