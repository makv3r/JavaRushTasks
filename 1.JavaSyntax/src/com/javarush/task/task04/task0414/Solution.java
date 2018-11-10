package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        //1. делится ли число на 4 и если делится, то оно не должно делится на 100 или
        //2. делится ли число на 100 и на 400

        if ((a % 4 == 0 && a % 100 != 0) || (a % 100 == 0 && a % 400 == 0)) System.out.println("количество дней в году: 366");
        else System.out.println("количество дней в году: 365");
    }
}