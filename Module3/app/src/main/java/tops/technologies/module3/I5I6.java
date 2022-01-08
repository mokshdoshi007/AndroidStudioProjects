package tops.technologies.module3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.webkit.WebView;

public class I5I6 extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_i5_i6);
        wv=findViewById(R.id.wv);
        if(isNetworkConnected())
        {
            wv=findViewById(R.id.wv);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadUrl("https://www.google.com/");
        }
        else
        {
            try {
                AlertDialog.Builder builder =new AlertDialog.Builder(this);
                builder.setTitle("No internet Connection");
                builder.setMessage("Please turn on internet connection to continue");
                builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
            catch (Exception e)
            {
                e.printStackTrace();

            }
        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean b = cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
        return b;
    }
}