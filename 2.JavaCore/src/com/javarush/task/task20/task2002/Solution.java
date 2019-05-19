package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("tmp", null);
            System.out.println("tmp path : " + yourFile.getCanonicalPath());
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user = new User();
            user.setFirstName("FName");
            user.setLastName("LName");
            user.setBirthDate(new GregorianCalendar(2000,1,1).getTime());
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            javaRush.users.add(user);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println("equal = " + javaRush.equals(loadedObject));
            System.out.println(javaRush);
            System.out.println(loadedObject);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);

            for (User user : users) {
                printWriter.print(user.getFirstName() + ":");
                printWriter.print(user.getLastName() + ":");
                printWriter.print((user.getBirthDate() != null ? user.getBirthDate().getTime() : null) + ":");
                printWriter.print(user.isMale() + ":");
                printWriter.print(user.getCountry());
                printWriter.println();
            }

            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String[] str = reader.readLine().split(":");
                User user = new User();
                user.setFirstName(str[0].equals("null") ? null : str[0]);
                user.setLastName(str[1].equals("null") ? null : str[1]);
                user.setBirthDate(str[2].equals("null") ? null : new Date(Long.parseLong(str[2])));
                user.setMale(Boolean.parseBoolean(str[3]));
                user.setCountry(str[4].equals("null") ? null : User.Country.valueOf(str[4]));
                users.add(user);
            }
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "JavaRush{" +
                    "users=" + users +
                    '}';
        }
    }
}
