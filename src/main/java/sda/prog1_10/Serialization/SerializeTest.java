package sda.prog1_10.Serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTest {
    public static void main(String[] args) {
        Person person= new Person("Jan","Kowalski",101);

        try {
            FileOutputStream fileOutputStream =
                    new FileOutputStream("Personserialized.data");
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
