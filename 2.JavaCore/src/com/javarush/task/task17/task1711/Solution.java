package com.javarush.task.task17.task1711;


import java.text.*;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c": { // -c name1 sex1 bd1 name2 sex2 bd2 ...
                synchronized (allPeople) {
                    if ((args.length - 1) % 3 == 0) {
                        for (int i = 1; i < args.length; i += 3) {
                            try {
                                Date date = dateFormat1.parse(args[i + 2]);
                                Person person = null;

                                if (args[i + 1].equals("м")) person = Person.createMale(args[i], date);
                                else if (args[i + 1].equals("ж")) person = Person.createFemale(args[i], date);

                                if (person != null) {
                                    allPeople.add(person);
                                    System.out.println(allPeople.indexOf(person));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;
                }
            }
            case "-u": { // -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                synchronized (allPeople) {
                    if ((args.length - 1) % 4 == 0) {
                        for (int i = 1; i < args.length; i += 4) {
                            try {
                                int index = Integer.parseInt(args[i]);
                                Person person = allPeople.get(index);
                                Date date = dateFormat1.parse(args[i + 3]);

                                person.setName(args[i + 1]);
                                if (args[i + 2].equals("м")) person.setSex(Sex.MALE);
                                else if (args[i + 2].equals("ж")) person.setSex(Sex.FEMALE);
                                else person.setSex(null);
                                person.setBirthDate(date);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                break;
            }
            case "-d": { // -d id1 id2 id3 id4 ...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        try {
                            int index = Integer.parseInt(args[i]);
                            Person person = allPeople.get(index);

                            person.setName(null);
                            person.setSex(null);
                            person.setBirthDate(null);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;
            }
            case "-i": {// -i id1 id2 id3 id4 ...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        try {
                            int index = Integer.parseInt(args[i]);
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
                break;
            }
        }

/**TEST
        for (Person person : allPeople) {
            StringBuffer s = new StringBuffer();
            s.append(person.getName());
            s.append(" ");
            s.append(person.getSex());
            s.append(" ");
            if (person.getBirthDate() != null)
                s.append(dateFormat2.format(person.getBirthDate()));
            System.out.println(s);
        }
 */
    }
}
