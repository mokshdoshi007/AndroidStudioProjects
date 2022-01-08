package tops.technologies.splash;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class SeekBar extends AppCompatActivity {
TextView tv;
Switch ms;
RatingBar rb;

android.widget.SeekBar sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        tv=findViewById(R.id.tv);
        sb=findViewById(R.id.skb);
        sb.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(android.widget.SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText("Percentage: "+progress+"%");
            }

            @Override
            public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
                seekBar.animate();
            }

            @Override
            public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
                seekBar.animate();
            }
        });
        ms=findViewById(R.id.ms);
        rb=findViewById(R.id.rb);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tv.setText("Rating: "+String.valueOf(rating));
            }
        });
    }
}