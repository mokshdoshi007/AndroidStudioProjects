package tops.technologies.xmlparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv);
        xmlParsing();
    }

    private void xmlParsing() {
        InputStream inputStream = this.getResources().openRawResource(R.raw.student);
        try
        {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            XmlPullParser parser = factory.newPullParser();

            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES,false);
            parser.setInput(inputStream,null);

            String tag_name="", text="";

            int event = parser.getEventType();

            while (event!=XmlPullParser.END_DOCUMENT)
            {
                tag_name = parser.getName();
                switch (event)
                {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text=parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        switch (tag_name)
                        {
                            case "name":
                                textView.append("\n\nName : "+text);
                                break;
                            case "rollno":
                                textView.append("\nRoll Number : "+text);
                                break;
                            case "age":
                                textView.append("\nAge : "+text);
                                break;
                        }
                        break;
                }
                event = parser.next();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}