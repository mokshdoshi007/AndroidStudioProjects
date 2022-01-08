package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class I8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i8);
        List<String> name = new LinkedList<String>();
        List<String>age = new LinkedList<String>();

        name.add("Moksh");
        age.add("20");
        name.add("Nimit");
        age.add("19");

        TableRow.LayoutParams  params1=new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT,1.0f);
        TableRow.LayoutParams params2=new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableLayout tableLayout=(TableLayout) findViewById(R.id.table);
        for(int i=0;i<name.size();i++)
        {
            TableRow row=new TableRow(this);
            TextView tv1=new TextView(this);
            TextView tv2=new TextView(this);
            tv1.setText(name.get(i));
            tv2.setText(age.get(i));
            tv1.setLayoutParams(params1);
            tv2.setLayoutParams(params1);
            row.addView(tv1);
            row.addView(tv2);
            row.setLayoutParams(params2);
            tableLayout.addView(row);
        }
    }
}