package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[10];
        String[] s = new String[10];

        for (int i = 0; i < 10; i++) {
            s[i] = reader.readLine();
            array[i] = s[i].length();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
    }
}
