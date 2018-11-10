package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        int count = 0;

        while (true) {
            int num = Integer.parseInt(reader.readLine());

            if (num == -1) {
                if (count != 0) System.out.println(sum/count);
                else System.out.println(sum);
                break;
            }

            sum += num;
            count++;
        }
    }
}

