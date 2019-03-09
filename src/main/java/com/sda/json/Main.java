package com.sda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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


        ObjectMapper mapper = new ObjectMapper();
        try {
            String personStr = mapper.writeValueAsString(person1);
            System.out.println(personStr);
            Files.write(Paths.get("person.json"), personStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);

        try{
            String peopleStr = mapper.writeValueAsString(people);
            Files.write(Paths.get("person.json"),peopleStr.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }


        List<Student> students = new ArrayList<>();
        students.add(new Student("Filip", "Pierwszy", new Address("Bydgoszcz", "Glinki")));
        students.add(new Student("Filip", "Drugi", new Address("Toruń", "Bydgoska")));
        students.add(new Student("Filip", "Trzeci", new Address("Wrocław", "Toruńska")));


        try{
            String studentsStr = mapper.writeValueAsString(students);
            Files.write(Paths.get("person.json"),studentsStr.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
