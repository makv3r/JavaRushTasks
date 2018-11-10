package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        maximum = array[0];
        minimum = array[0];

        for (int i = 1; i < array.length; i++) {
            if (maximum < array[i]) maximum = array[i];
            if (minimum > array[i]) minimum = array[i];
        }

        System.out.print(maximum + " " + minimum);
    }
}
