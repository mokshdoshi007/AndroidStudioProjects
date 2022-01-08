package tops.technologies.project.model;

public class Person {
    String name,email,gender,age,password;

    public Person(String name, String email, String gender, String age, String password) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.password = password;
    }

    public String getAge() { return age;}

    public void setAge(String age) { this.age = age;}

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
