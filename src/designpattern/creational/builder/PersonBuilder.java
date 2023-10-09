package designpattern.creational.builder;

public class PersonBuilder {
    private final String name; //mandatory
    private final String email; //mandatory
    private int age; //optional
    private String address; //optional
    private String university; //added later //optional

    //mandatory parameters
    public PersonBuilder(String name, String email){
        this.name = name;
        this.email = email;
    }

    public PersonBuilder age(int age){
        this.age = age;
        return this;
    }

    public PersonBuilder address(String address){
        this.address = address;
        return this;
    }

    //added later
    public PersonBuilder university(String university){
        this.university = university;
        return this;
    }

    public Person build(){
        return new Person(this);
    }

    //getter setter


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getUniversity() {
        return university;
    }
}
