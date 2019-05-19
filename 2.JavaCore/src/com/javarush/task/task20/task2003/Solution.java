package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static String fileName;


    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        //fileName = "/home/thunder/java/javarush/filework/app.properties";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);
        fileInputStream.close();
        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties();

        for (Map.Entry<String, String> entry : properties.entrySet()) {
            property.put(entry.getKey(), entry.getValue());
        }

        property.save(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties property = new Properties() {{
            load(inputStream);
        }};

        for (Map.Entry<Object, Object> entry : property.entrySet()) {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();

        printPropertiesMap();
        properties.put("new_key", "new_line");

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        solution.save(fileOutputStream);
        fileOutputStream.close();

        properties.clear();
        solution.fillInPropertiesMap();

        printPropertiesMap();
    }



    private static void printPropertiesMap() {
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
    }
}
