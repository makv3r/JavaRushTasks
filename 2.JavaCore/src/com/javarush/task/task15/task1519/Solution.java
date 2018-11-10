package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();


        String s = "";
        while (!(s = reader.readLine()).equals("exit")) {
            list.add(s);
        }

        for (String tmp : list) {
            try {
                Integer value = Integer.parseInt(tmp);
                if (value > 0 && value < 128) print(value.shortValue());
                else print(value);
            } catch (Exception e1) {
                try {
                    print(Double.parseDouble(tmp));
                } catch (Exception e2) {
                    print(tmp);
                }
            }

        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
