package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class A9 extends AppCompatActivity {

    private int seekR, seekG, seekB;
    SeekBar redSeekBar, greenSeekBar, blueSeekBar;
    LinearLayout linearLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a9);

        linearLayout = findViewById(R.id.ll4);
        redSeekBar = (SeekBar) findViewById(R.id.redbar);
        greenSeekBar = (SeekBar) findViewById(R.id.greenbar);
        blueSeekBar = (SeekBar) findViewById(R.id.bluebar);
        updateBackground();
        redSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            updateBackground();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };
        private void updateBackground() {
            seekR = redSeekBar.getProgress();
            seekG = greenSeekBar.getProgress();
            seekB = blueSeekBar.getProgress();
            linearLayout.setBackgroundColor(0xff000000
                    + seekR * 0x10000
                    + seekG * 0x100
                    + seekB);
        }
}