package tops.technologies.domparsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity2 extends AppCompatActivity {
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        layout=findViewById(R.id.main2);
        try
        {
            InputStream inputStream = getAssets().open("employees.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(inputStream);

            Element element = document.getDocumentElement();
            element.normalize();

            NodeList list = document.getElementsByTagName("employee");
            for (int i=0; i<list.getLength(); i++)
            {
                TextView textView = new TextView(this);

                Node node = list.item(i);

                if(node.getNodeType()==Node.ELEMENT_NODE)
                {
                    Element element1 = (Element) node;
                    textView.setTextSize(15);
                    textView.setTextColor(0xffff0000);

                    textView.setText("ID: "+getValue("id",element1)+
                            "\nName: "+getValue("name",element1)+
                            "\nDepartment: "+getValue("department",element1)+
                            "\nType: "+getValue("type",element1)+
                            "\nEmail: "+getValue("email",element1)+"\n");
                    
                    layout.addView(textView);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String getValue(String tag, Element element)
    {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}