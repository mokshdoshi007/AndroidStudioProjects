package tops.technologies.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    double lat = 40.712774, lon = -74.006091;
    String units = "imperial";
    String url = String.format("https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&units=%s&appid=%s", lat, lon, units, "4a7c24cda5111d0166032bdf02665931");
    //String url="http://api.openweathermap.org/data/2.5/weather?lat=40.712774&lon=-74.006091&units=imperial&appid=4a7c24cda5111d0166032bdf02665931";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv);
        new GetWeatherTask(textView).execute(url);
    }
}
class GetWeatherTask extends AsyncTask<String,Void,String>
{
    private final TextView textView;
    public GetWeatherTask(TextView textView)
    {
        this.textView=textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String weather="UNDEFINED";
        try
        {
            URL url = new URL(strings[0]);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            //StringBuilder stringBuilder = new StringBuilder();

            String inputString=bufferedReader.readLine();
            //stringBuilder.append(inputString);
            /*while (inputString!=null)
            {

            }*/
            JSONObject toplevel = new JSONObject(inputString);
            JSONObject main = toplevel.getJSONObject("main");
            weather=String.valueOf(main.getDouble("temp"));
            httpsURLConnection.disconnect();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return weather;
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText("Current Weather: "+s);
    }
}