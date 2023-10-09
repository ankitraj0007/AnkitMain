package designpattern.creational.builder;

public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder("ankit", "raj")
                .build();

        Person person1 = new PersonBuilder("ankit", "raj")
                .age(30)
                .address("bangalore")
                .build();

        System.out.println(person);
        System.out.println(person1);

        PersonBuilder personBuilder = new PersonBuilder("ankit", "raj");
        Person person2 = personBuilder
                .university("NITJ")
                .build();
        System.out.println(person2);

        Student student = new Student.StudentBuilder("ankit","NITJ").age(30).build();
        System.out.println(student);
    }
}
