package tops.technologies.playsongfromraw;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        mediaPlayer = MediaPlayer.create(this,R.raw.hasi);

        b1.setOnClickListener(v -> {
            if(!mediaPlayer.isPlaying())
                mediaPlayer.start();
        });
        b2.setOnClickListener(v -> {
            mediaPlayer.stop();
        });
    }
}