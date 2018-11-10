package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(reader.readLine()) % 5;

        if (a >= 0 && a < 3) System.out.println("зелёный");
        else if (a >= 3 && a < 4) System.out.println("жёлтый");
        else if (a >= 4 && a < 5) System.out.println("красный");
    }
}