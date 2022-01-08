package tops.technologies.files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    private String filenameInternal = "data.txt";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    public void write(View view)
    {
        String ok = "Write";
        ok =tv.getText().toString();
        createUpdateFile(filenameInternal, ok, false);
    }


    public void append(View view)
    {
        String ok = "Append";
        //ok= (String) tv.getText();
        createUpdateFile(filenameInternal, ok, true);
    }

    private void createUpdateFile(String filenameInternal, String ok, boolean b)
    {
        FileOutputStream outputStream;
        try {
            if(b)
                {
                    outputStream = openFileOutput(filenameInternal, MODE_APPEND);
                }
            else
                {
                    outputStream = openFileOutput(filenameInternal, MODE_PRIVATE);
                }
            outputStream.write(ok.getBytes());
            outputStream.flush();
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void read(View view) {
        try
        {
            FileInputStream fileInputStream = openFileInput(filenameInternal);
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(fileInputStream));
            StringBuffer stringBuffer = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line!=null)
            {
                stringBuffer.append(line);
                line=bufferedReader.readLine();
            }
            tv.setText(stringBuffer.toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}