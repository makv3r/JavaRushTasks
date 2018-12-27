package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");

            int bufferSize = fileInputStream.available();
            int countSpace = 0;
            if (bufferSize > 0) {
                byte[] buffer = new byte[bufferSize];
                fileInputStream.read(buffer);
                for (int i = 0; i < buffer.length; i++) {
                    if (buffer[i] == ' ') countSpace++;
                }
            }
            fileInputStream.close();

            System.out.println(String.format("%.2f", ((float) countSpace / bufferSize) * 100));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
