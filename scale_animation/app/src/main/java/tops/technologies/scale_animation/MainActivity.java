package tops.technologies.scale_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imagex);
        button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
            imageView.startAnimation(animation);
        });
    }
}