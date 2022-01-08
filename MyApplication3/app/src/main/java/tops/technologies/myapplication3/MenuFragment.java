package tops.technologies.myapplication3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment {

    String AndroidOS [] = {"Cupcake",
            "Donut",
            "Eclair",
            "Froyo",
           "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Nougat",
            "Oreo",
            "Pie"};
    String Version [] = {"1.5",
            "1.6",
            "2.0 - 2.1",
            "2.2 - 2.2.3",
            "2.3 - 2.3.7",
            "3.0 - 3.2.6",
            "4.0 - 4.0.4",
            "4.1 - 4.3.1",
            "4.4 - 4.4.4",
            "5.0 - 5.1.1",
            "6.0 - 6.0.1",
            "7.1.0 - 7.1.2",
            "8.1",
            "9.0"};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_menu_fragment,container,false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,AndroidOS);
        setListAdapter(adapter);
        return view;
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        TextFragment fragment = (TextFragment) getFragmentManager().findFragmentById(R.id.f2);
        fragment.change(AndroidOS[position], "Version"+Version[position]);
    }
}