package tops.technologies.module3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class DI3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di3);
        
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setIcon(R.drawable.ic_launcher_background);
        builderSingle.setTitle("Select One City:-");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DI3.this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("Ahmedabad");
        arrayAdapter.add("Mumbai");
        arrayAdapter.add("Delhi");
        arrayAdapter.add("Chennai");
        arrayAdapter.add("Kolkata");

        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                TextView textView = findViewById(R.id.tv7);
                textView.setText(strName);
            }
        });
        builderSingle.show();
    }
}