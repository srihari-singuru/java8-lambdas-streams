package main;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class I_CollectGroupingBy {
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

        // create a map with name as key, and the value is all the people with that name
        Map<String, List<Person>> personMap =
                people.stream()
                        .collect(Collectors.groupingBy(
                                person -> person.getName()
                        ));
        System.out.println(personMap);
        // groupingBy() prepares a group of elements using the key defined inside it.
        // <string, List<people>> but not <string, person>

        // let's try little different here
        // create a map with name as key, and the value is all the ages of people with that name
        Map<String, List<Integer>> personAgeMap =
                people.stream()
                        .collect(Collectors.groupingBy(
                                Person::getName,
                                Collectors.mapping(
                                        Person::getAge,
                                        Collectors.toList()
                                )
                        ));
        System.out.println(personAgeMap);
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
