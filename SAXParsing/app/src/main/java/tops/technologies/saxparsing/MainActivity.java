package tops.technologies.saxparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button;
    ListView listView;
    List<Employee> employees = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list);
        button=findViewById(R.id.button);

        button.setOnClickListener(v -> {
            try
            {
                employees = Parser.parse(getAssets().open("employees.xml"));
                ArrayAdapter <Employee> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, employees);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, employees.get(position).getDetails(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }
}