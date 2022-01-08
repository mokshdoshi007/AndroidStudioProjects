package tops.technologies.adapteri3;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private Adapter adapter;
    private ArrayList<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        buildRecyclerView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });
        return true;
    }

    private void filter(String text) {
        ArrayList<Model> filteredlist = new ArrayList<>();

        for (Model item : list) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item);
            }
        }
        if (filteredlist.isEmpty())
        {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.filterList(filteredlist);
        }
    }

    private void buildRecyclerView() {
        list = new ArrayList<>();
        list.add(new Model("Holi", "Holi is a popular ancient Hindu festival, also known as the \"Festival of Love\", the \"Festival of Colours\", and the \"Festival of Spring\". The festival celebrates the eternal and divine love of Radha Krishna."));
        list.add(new Model("Uttarayan", "Makar Sankranti or Uttarayan or Maghi or simply Sankranti, also known in Bangladesh as Poush Sankranti, is a festival day in the Hindu calendar, dedicated to the deity Surya. It is observed each year the day Sun enters the Capricorn zodiac which corresponds with the month of January as per the Gregorian calendar."));
        list.add(new Model("Diwali", "Diwali is a festival of lights and one of the major festivals celebrated by Hindus, Jains, Sikhs and some Buddhists, notably Newar Buddhists. The festival usually lasts five days and is celebrated during the Hindu lunisolar month Kartika."));
        list.add(new Model("Navratri", "Navaratri is a Hindu festival that spans nine nights and is celebrated every year in the autumn. It is observed for different reasons and celebrated differently in various parts of the Indian cultural sphere. Theoretically, there are four seasonal Navaratri."));
        list.add(new Model("Christmas", "Christmas is an annual festival commemorating the birth of Jesus Christ, observed primarily on December 25 as a religious and cultural celebration by billions of people around the world."));
        list.add(new Model("Eid","Eid al-Fitr, also called the \"Festival of Breaking the Fast\" or Lesser Eid, or simply Eid, is a religious holiday celebrated by Muslims worldwide that marks the end of the month-long dawn-to-sunset fasting of Ramadan."));

        adapter = new Adapter(list, MainActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
