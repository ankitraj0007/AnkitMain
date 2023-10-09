package designpattern.creational.builder;

public class Person {

    private final String name; //mandatory
    private final String email; //mandatory
    private final int age; //optional
    private final String address; //optional
    private final String university; //added later //optional

    public Person(PersonBuilder builder){
        this.name = builder.getName();
        this.email = builder.getEmail();
        this.age = builder.getAge();
        this.address = builder.getAddress();
        this.university = builder.getUniversity();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", university='" + university + '\'' +
                '}';
    }
}
