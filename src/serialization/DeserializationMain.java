package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("output.txt"));
        EmployeeSerialized e1 = (EmployeeSerialized) inputStream.readObject();
        EmployeeSerialized e2 = (EmployeeSerialized) inputStream.readObject();

        System.out.println(e1);
    }

}
