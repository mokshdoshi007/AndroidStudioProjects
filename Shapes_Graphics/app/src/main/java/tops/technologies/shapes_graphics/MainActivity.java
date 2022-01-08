package tops.technologies.shapes_graphics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimationDrawable animationDrawable;
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(new MLayout(this));
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.moksh);
        animationDrawable = (AnimationDrawable) imageView.getBackground();
        button.setOnClickListener(v -> {
            if(animationDrawable.isRunning())
                animationDrawable.stop();
            else
                animationDrawable.start();
        });
    }

    private class MLayout extends View {

        public MLayout(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();

            paint.setStyle(Paint.Style.FILL);

            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            paint.setAntiAlias(false);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(20,20,15, paint);

            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(60,20,15, paint);

            canvas.rotate(-45);
            canvas.drawText("Rotation", 40,100,paint);

            //canvas.restore();

            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            canvas.drawCircle(60,20,15, paint);
            /*paint.setColor(Color.YELLOW);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(250,250,100, paint);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(50,50,200,100,paint);*/
        }
    }
}