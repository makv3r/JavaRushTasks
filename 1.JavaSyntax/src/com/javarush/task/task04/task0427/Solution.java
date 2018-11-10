package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());

        if (a > 0 && a < 1000) {
            if (a % 2 == 0) {
                System.out.print("четное");
            }
            else {
                System.out.print("нечетное");
            }

            if (a < 10) System.out.println(" однозначное число");
            else if (a < 100) System.out.println(" двузначное число");
            else if (a < 1000) System.out.println(" трехзначное число");
        }
    }
}
