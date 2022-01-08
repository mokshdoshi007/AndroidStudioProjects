package tops.technologies.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class B3 extends AppCompatActivity {
    static List<String> cities = new ArrayList<String>();
    static ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b3);
        ListView listView = findViewById(R.id.list);
        cities.add("Ahmedabad");
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Chennai");
        cities.add("Kolkata");
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, cities);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            registerForContextMenu(listView);
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,v.getId(),0,"Edit");
        menu.add(0,v.getId(),0,"View");
        menu.add(0,v.getId(),0,"Delete");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;
        if (item.getTitle().equals("Edit"))
        {
            Intent intent = new Intent(B3.this,EditCity.class);
            intent.putExtra("index",listPosition);
            startActivity(intent);
        }
        if (item.getTitle().equals("View"))
        {
            new AlertDialog.Builder(this)
                    .setTitle("View City")
                    .setMessage("Your selected city is: "+cities.get(listPosition))
                    .show();
        }
        if (item.getTitle().equals("Delete")) {
            cities.remove(listPosition);
            adapter.notifyDataSetChanged();
        }
        return true;
    }
}