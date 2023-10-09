package common.equalAndHashcode;

import java.util.Objects;

public class Contact {

    private String name;
    private int age;

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //if two objects are equal then they must have same hashcode -> hashcode contract
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (age != contact.age) return false;
        return Objects.equals(name, contact.name);
    }

    //to improve performance in hash based collection to save and search
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
