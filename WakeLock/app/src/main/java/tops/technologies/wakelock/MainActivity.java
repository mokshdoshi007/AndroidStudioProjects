package tops.technologies.wakelock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

public class MainActivity extends AppCompatActivity {
    PowerManager powerManager;
    PowerManager.WakeLock wakeLock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        if(powerManager!=null)
        {
            wakeLock=powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"Wakelock:Moksh");
        }
        wakeLock.acquire(60*1000L);//1min
        wakeLock.release();
    }
}