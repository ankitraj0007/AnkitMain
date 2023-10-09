package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationMain {

    public static void main(String[] args) throws IOException {

        EmployeeSerialized employeeSerialized1 = new EmployeeSerialized(1, "ankit");
        EmployeeSerialized employeeSerialized2 = new EmployeeSerialized(2, "aparna");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("output.txt"));
        objectOutputStream.writeObject(employeeSerialized1);
        objectOutputStream.writeObject(employeeSerialized2);

        objectOutputStream.flush();
        objectOutputStream.close();

    }

}
