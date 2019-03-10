package com.sda.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fmucko
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String name;
    private String lastName;
    private int age;
}
