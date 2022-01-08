package tops.technologies.controlsong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.startservice).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlaySongfromService.class);
            startService(intent);
        });
        findViewById(R.id.stopservice).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PlaySongfromService.class);
            stopService(intent);
        });
    }
}