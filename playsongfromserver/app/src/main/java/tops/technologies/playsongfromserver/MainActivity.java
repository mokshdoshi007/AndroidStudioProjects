package tops.technologies.playsongfromserver;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    //String url = "https://drive.google.com/file/d/1TR49VaHwXXoAZ9L4pYjbAyxO53NxzQYE/view?usp=sharing";
    String url="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-2.mp3";
    private MediaPlayer mediaPlayer;
    ImageButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=findViewById(R.id.b1);
    }

    public void playsong(View view) {
        if(mediaPlayer==null)
        {
            mediaPlayer = new MediaPlayer();
            try
            {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(this);
                b.setImageResource(R.drawable.pause);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            if (mediaPlayer.isPlaying())
            {
                b.setImageResource(R.drawable.play);
                mediaPlayer.pause();
            }
            else
            {
                b.setImageResource(R.drawable.pause);
                mediaPlayer.start();
            }
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
}