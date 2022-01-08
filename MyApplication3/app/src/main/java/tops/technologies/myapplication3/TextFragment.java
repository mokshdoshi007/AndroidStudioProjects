package tops.technologies.myapplication3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment
{
    TextView OS,Ver;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_text_fragment, container, false);
        OS = view.findViewById(R.id.AndroidOs);
        Ver = view.findViewById(R.id.Version);
        return view;
    }
    public void change(String txt, String txt2)
    {
        OS.setText(txt);
        Ver.setText(txt2);
    }
}

