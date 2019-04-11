package com.javarush.task.task19.task1921;

import java.io.*;
import java.util.*;


/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String name = line.replaceAll("[\\w]", "").trim();
            String numbers[] = line.substring(name.length()).trim().split(" ");

            Date date = new GregorianCalendar(
                    Integer.parseInt(numbers[numbers.length - 1]),
                    Integer.parseInt(numbers[numbers.length - 2]) - 1,
                    Integer.parseInt(numbers[numbers.length - 3])
            ).getTime();

            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();


        //for (Person person : PEOPLE) {
        //    System.out.println(person.getName() + " " + person.getBirthDate());
        //}
    }
}
