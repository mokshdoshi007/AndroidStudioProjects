package tops.technologies.saxparsing;

public class Employee {
    String id,name,department,type,email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String toString()
    {
        return id+"\n"+name;
    }
    public String getDetails()
    {
        String result = id+": "+name+"\n"+department+"-"+type+"\n"+email;
        return result;
    }
}
