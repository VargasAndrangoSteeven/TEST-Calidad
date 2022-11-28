package Model;

public class AdminVO{
    private String user;
    private String password;
    private String name;
    private String lastName;
    private int     age;
    private String gender;
    private String location;

    public AdminVO(String name, String lastName, int age, String gender, String location) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    
    public AdminVO() {
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}