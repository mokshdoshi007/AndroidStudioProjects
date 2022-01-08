package tops.technologies.exam;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;

public class Home extends Fragment {
    TextView name,email,password,gender;
    String sharedpreffile="data";
    SharedPreferences preferences;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        password=view.findViewById(R.id.password);
        gender=view.findViewById(R.id.gender);
        preferences = getActivity().getSharedPreferences(sharedpreffile,MODE_PRIVATE);
        read();
        return view;
    }
    private void read()
    {
        name.setText("\n"+preferences.getString("name","Not Found"));
        email.setText("\n"+preferences.getString("email","Not Found"));
        password.setText("\n"+preferences.getString("password","Not Found"));
        gender.setText("\n"+preferences.getString("gender","Not Found"));
    }
}