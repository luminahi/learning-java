package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.Optional;
import java.io.ObjectInputStream;
import serialize.lib.Person;

public class App {

    private static void serialize(Person person) {
        try {
            Path path = Path.of("src/serialize/file.txt");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toFile()));
            out.writeObject(person);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    private static Optional<Person> deserialize() {
        Person person = null;
        try {
            Path path = Path.of("src/serialize/file.txt");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()));
            person = (Person) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(person);
    }

    public static void main(String[] args) {
        
        Person person0 = new Person("alex", 15);
        Person person1 = new Person("alex", 15);
        
        System.out.println(person0.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person0.equals(person1));
        System.out.println(person1.equals(person1));

        serialize(person0);
        Optional<Person> person = deserialize();
        
        System.out.println(person.map(Person::getName).orElse(""));
        System.out.println(person.map(Person::getAge).orElse(-1));
        System.out.println(person.map(Person::hashCode).orElse(0));

    }
}
