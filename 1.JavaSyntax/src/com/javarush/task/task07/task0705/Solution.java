package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        int[] array1 = new int[10];
        int[] array2 = new int[10];

        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
            if (i < 10) array1[i] = array[i];
            else array2[i - 10] = array[i];
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(array2[i]);
        }
    }
}
