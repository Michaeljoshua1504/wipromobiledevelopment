import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Override toString for a readable representation of the Person
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class PersonSort {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Bhanu", 24));
        people.add(new Person("Michael", 23));
        people.add(new Person("Ali", 24));
        people.add(new Person("Jeelan", 25));

        // Print the list before sorting
        System.out.println("Before sorting:");
        people.forEach(System.out::println);

        // Sort the list by age using a lambda expression
        people.sort(Comparator.comparingInt(Person::getAge));

        // Print the list after sorting
        System.out.println("\nAfter sorting by age:");
        people.forEach(System.out::println);
    }
}

