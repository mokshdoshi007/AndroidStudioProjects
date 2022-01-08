package tops.technologies.saxparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MHandler extends DefaultHandler {
    private List<Employee> employeeList;
    private String tempVal;
    private Employee tempEmp;
    public MHandler()
    {
        employeeList = new ArrayList<Employee>();
    }
    public List<Employee> getEmployeeList()
    {
        return employeeList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        tempVal="";
        if(qName.equalsIgnoreCase("employee"))
            tempEmp = new Employee();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch,start,length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("employee"))
            employeeList.add(tempEmp);
        else if(qName.equalsIgnoreCase("id"))
            tempEmp.setId(tempVal);
        else if(qName.equalsIgnoreCase("name"))
            tempEmp.setName(tempVal);
        else if(qName.equalsIgnoreCase("department"))
            tempEmp.setDepartment(tempVal);
        else if(qName.equalsIgnoreCase("type"))
            tempEmp.setType(tempVal);
        else if(qName.equalsIgnoreCase("email"))
            tempEmp.setEmail(tempVal);
    }
}
