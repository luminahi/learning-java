package serialize.lib;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        
        Person person = (Person) obj;
        
        if (person.age == this.age && person.name == this.name)
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
