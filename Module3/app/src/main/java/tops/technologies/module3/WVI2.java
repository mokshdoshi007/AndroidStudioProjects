package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WVI2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_v_i2);
        WebView webView = findViewById(R.id.wv3);
        webView.loadUrl("file:///android_asset/index.html");
    }
}