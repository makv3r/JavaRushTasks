package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int day = Integer.parseInt(reader.readLine());

        if (day == 1) System.out.println("понедельник");
        else if (day == 2) System.out.println("вторник");
        else if (day == 3) System.out.println("среда");
        else if (day == 4) System.out.println("четверг");
        else if (day == 5) System.out.println("пятница");
        else if (day == 6) System.out.println("суббота");
        else if (day == 7) System.out.println("воскресенье");
        else System.out.println("такого дня недели не существует");
    }
}