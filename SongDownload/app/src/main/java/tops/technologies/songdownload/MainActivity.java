package tops.technologies.songdownload;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.widget.Button;
import android.widget.SeekBar;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Button button;
    SeekBar seekBar;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        button=findViewById(R.id.startbutton);
        seekBar=findViewById(R.id.progress);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(context,DownloadService.class);
            intent.putExtra("url","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
            intent.putExtra("receiver", new DownloadReceiver(new Handler()));
            startService(intent);
        });
    }

    private class DownloadReceiver extends ResultReceiver {
        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            if(resultCode==DownloadService.UPDATE_PROGRESS)
            {
                int progress=resultData.getInt("progress");
                seekBar.setProgress(progress);
            }
        }
    }
}