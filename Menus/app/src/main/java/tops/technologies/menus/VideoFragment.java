package tops.technologies.menus;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

public class VideoFragment extends Fragment {

    SurfaceView surfaceView;
    MediaPlayer mediaPlayer;
    SurfaceHolder surfaceHolder;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_video, container, false);
        MediaController mc= new MediaController(getActivity());

        VideoView view = rootView.findViewById(R.id.vv);
        String path="https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
        view.setVideoURI(Uri.parse(path));
        view.setMediaController(mc);
        view.start();
        return rootView;
    }
}