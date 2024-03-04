package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class H_CollectAsMap {
    private static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", "Female", 20),
                new Person("Sara", "Female", 22),
                new Person("Bob", "Male", 20),
                new Person("Paula", "Female", 32),
                new Person("Paul", "Male", 32),
                new Person("Jack", "Male", 2),
                new Person("Jack", "Male", 72),
                new Person("Jill", "Female", 12)
        );
    }
    public static void main(String[] args) {
        List<Person> people = createPeople();

        // create a map with name and age as key, and the person as value
        Map<String, Person> personMap =
                people.stream()
                        .collect(Collectors.toMap(
                                person -> person.getName()+" - "+person.getAge(),
                                person -> person
                        ));
        System.out.println(personMap);

        // toMap() prepares a map using key and value defined inside it.
        // <string, person>, but not <string, List<people>>
    }

    static class Person {
        String name;
        String gender;
        int age;

        public Person(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
