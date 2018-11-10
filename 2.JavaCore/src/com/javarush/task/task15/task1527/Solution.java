package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String s = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        //String s = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";

        String s;

        try {
            s = reader.readLine();
        } catch (Exception e) {
            return;
        }

        String obj = "";
        String[] array = s.substring(s.indexOf('?') + 1).split("&");

        for (int i = 0; i < array.length; i++) {
            if (array[i].contains("=")) {
                System.out.print(array[i].substring(0,array[i].indexOf("=")) + " ");
                if (array[i].substring(0,array[i].indexOf("=")).equals("obj")) {
                    obj = array[i].substring(array[i].indexOf("=") + 1);
                }
            }
            else System.out.print(array[i] + " ");
        }

        if (!obj.isEmpty()) {
            try {
                System.out.println();
                alert(Double.parseDouble(obj));
            } catch (Exception e) {
                alert(obj);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
