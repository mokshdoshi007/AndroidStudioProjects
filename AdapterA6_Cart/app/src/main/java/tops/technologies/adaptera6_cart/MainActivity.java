package tops.technologies.adaptera6_cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<ModelClass> list;
    public static TextView maintotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv);
        maintotal=findViewById(R.id.tv_total);
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        list = new ArrayList<>();
        list.add(new ModelClass("TShirt","500",0));
        list.add(new ModelClass("Jeans","1200",0));
        list.add(new ModelClass("Perfume","750",0));

        adapter = new Adapter(list, MainActivity.this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}