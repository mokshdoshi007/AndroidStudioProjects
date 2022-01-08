package tops.technologies.module3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class WVI1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_w_v_i1);
    }

    public void search(View view) {
        EditText editText = findViewById(R.id.editText);
        WebView webView = findViewById(R.id.wv2);
        String url = "https://www.google.com/search?q="+editText.getText();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}