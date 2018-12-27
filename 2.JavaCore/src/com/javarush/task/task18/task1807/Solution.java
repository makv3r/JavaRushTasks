package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");

            int count = 0;
            while (fileInputStream.available() > 0) {
                if (fileInputStream.read() == ',') count++;
            }
            fileInputStream.close();

            System.out.print(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
