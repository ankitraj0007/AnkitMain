package designpattern.creational.builder;

public class Student {

    //mandatory
    private String name;
    private String university;

    //optional
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(StudentBuilder builder){
        this.name = builder.name;
        this.university = builder.university;
        this.age = builder.age;
    }

    public static class StudentBuilder{
        private String name;
        private String university;
        private int age;

        public StudentBuilder(String name, String university){
            this.name = name;
            this.university = university;
        }

        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

}
