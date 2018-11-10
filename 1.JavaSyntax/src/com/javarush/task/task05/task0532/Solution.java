package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int maximum = 0;

        //напишите тут ваш код

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(reader.readLine());
            if (maximum < input || maximum == 0) maximum = input;
        }

        System.out.println(maximum);
    }
}
