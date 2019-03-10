package com.sda.savejson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.json.Address;
import com.sda.json.Person;
import com.sda.json.Student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmucko
 */
public class Main {


    public static void main(String[] args) {
        Person person1 = new Person("Filip", "Mućko", 28);
        Person person2 = new Person("Janusz", "Bigos", 51);
        Person person3 = new Person("Jan", "Bigos", 21);
        Person person4 = new Person("Grażyna", "Bigos", 53);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Filip", "Pierwszy", new Address("Bydgoszcz", "Glinki")));
        students.add(new Student("Filip", "Drugi", new Address("Toruń", "Bydgoska")));
        students.add(new Student("Filip", "Tszeci", new Address("Wrocław", "Toruńska")));

        ObjectMapper mapper = new ObjectMapper();
        try {
            String peopleStr = mapper.writeValueAsString(people);
            Files.write(Paths.get("person.json"), peopleStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File studentFile = new File("student.json");
            mapper.writeValue(studentFile, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
