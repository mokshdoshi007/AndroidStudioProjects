package tops.technologies.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et);
        button = findViewById(R.id.btn);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    int ttslang = textToSpeech.setLanguage(Locale.ENGLISH);
                    if(ttslang==TextToSpeech.LANG_MISSING_DATA || ttslang==TextToSpeech.LANG_NOT_SUPPORTED)
                        Log.e("TTS","Language Not Supported");
                    else
                        Log.e("TTS","Language Supported");
                }
                else
                    Toast.makeText(MainActivity.this, "Failed to Init", Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(v -> {
            String data = editText.getText().toString();
            int speechstatus = textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);
            if (speechstatus==TextToSpeech.ERROR)
                Log.e("TTS","Error converting Text to Speech");
            else
                textToSpeech.speak(data);
        });
    }
}