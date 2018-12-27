package com.javarush.task.task17.task1710;

import java.text.*;
import java.util.*;


/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        if (args[0].equals("-c")) { // -c name sex bd
            if (args.length == 4) {
                try {
                    Date date = dateFormat1.parse(args[3]);
                    Person person = null;

                    if (args[2].equals("м")) person = Person.createMale(args[1], date);
                    else if (args[2].equals("ж")) person = Person.createFemale(args[1], date);

                    if (person != null) {
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (args[0].equals("-u")) { // -u id name sex bd
            if (args.length == 5) {
                try {
                    int index = Integer.parseInt(args[1]);
                    Person person = allPeople.get(index);
                    Date date = dateFormat1.parse(args[4]);

                    person.setName(args[2]);
                    if (args[3].equals("м")) person.setSex(Sex.MALE);
                    else if (args[3].equals("ж")) person.setSex(Sex.FEMALE);
                    else person.setSex(null);
                    person.setBirthDate(date);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (args[0].equals("-d")) { // -d id
            if (args.length == 2) {
                try {
                    int index = Integer.parseInt(args[1]);
                    Person person = allPeople.get(index);

                    person.setName(null);
                    person.setSex(null);
                    person.setBirthDate(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (args[0].equals("-i")) { // -i id
            if (args.length == 2) {
                try {
                    int index = Integer.parseInt(args[1]);
                    Person person = allPeople.get(index);
                    StringBuilder sb = new StringBuilder();

                    sb.append(person.getName());
                    sb.append(" ");
                    if (person.getSex().equals(Sex.MALE)) sb.append("м ");
                    else if (person.getSex().equals(Sex.FEMALE)) sb.append("ж ");
                    sb.append(dateFormat2.format(person.getBirthDate()));

                    System.out.println(sb.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}