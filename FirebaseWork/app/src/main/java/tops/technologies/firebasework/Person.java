package tops.technologies.firebasework;

public class Person {
    String name,email,password;
    Person(String n, String e, String p)
    {
        name=n;
        email=e;
        password=p;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
