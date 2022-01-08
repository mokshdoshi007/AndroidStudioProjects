package tops.technologies.songdownload;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.SeekBar;

import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadService extends IntentService {
    public static final int UPDATE_PROGRESS=8344;
    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String urltoDownload = intent.getStringExtra("url");
        ResultReceiver  resultReceiver = intent.getParcelableExtra("receiver");
        try {
            URL url = new URL(urltoDownload);
            URLConnection connection = url.openConnection();
            connection.connect();

            int filelength=connection.getContentLength();

            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            String path ="/sdcard/myvideo.mp4";

            OutputStream outputStream = new FileOutputStream(path);

            byte data[] = new byte[1024];
            long total=0;
            int count=0;
            while ((count=inputStream.read(data))!=-1)
            {
                total+=count;

                Bundle resultData = new Bundle();
                resultData.putInt("progress", (int)(total*100/filelength));
                resultReceiver.send(UPDATE_PROGRESS,resultData);
                outputStream.write(data,0,count);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        Bundle resultData = new Bundle();
        resultData.putInt("progress", 100);
        resultReceiver.send(UPDATE_PROGRESS,resultData);
    }
}
