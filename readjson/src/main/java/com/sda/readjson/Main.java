package com.sda.readjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.json.Student;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author fmucko
 */
public class Main {
    public static void main(String[] args) {
        File studentFile = new File("student.json");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Student[] studentArr = mapper.readValue(studentFile, Student[].class);
            List<Student> studentList = Arrays.asList(studentArr);
            System.out.println(Arrays.toString(studentList.toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
