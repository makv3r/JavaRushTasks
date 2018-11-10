package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;

        while (true) {
            int num = Integer.parseInt(reader.readLine());
            sum += num;

            if (num == -1) {
                System.out.println(sum);
                break;
            }
        }
    }
}
