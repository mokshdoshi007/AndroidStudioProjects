package tops.technologies.saxparsing;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

public class Parser {
    public static List<Employee> parse(InputStream inputStream)
    {
        List<Employee> employees = null;
        try
        {
            XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
            MHandler handler = new MHandler();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(new InputSource(inputStream));
            employees = handler.getEmployeeList();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employees;
    }
}
