package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());

        if (a <= 0 || b <= 0) throw new Exception();

        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        System.out.println(a);
    }
}
