package tops.technologies.menus;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AudioFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_audio, container, false);
        Button b1=view.findViewById(R.id.b1);
        Button b2=view.findViewById(R.id.b2);

        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.hasi);

        b1.setOnClickListener(v -> {
                mediaPlayer.start();
        });
        b2.setOnClickListener(v -> {
            mediaPlayer.stop();
        });
        return view;
    }
}