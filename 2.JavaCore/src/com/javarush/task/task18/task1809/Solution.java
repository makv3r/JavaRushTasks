package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");
            //FileOutputStream fileOutputStream = new FileOutputStream("/home/thunder/Downloads/file2.txt");

            int bufferSize = fileInputStream.available();
            if (fileInputStream.available() > 0) {
                byte[] buffer1 = new byte[bufferSize];
                byte[] buffer2 = new byte[bufferSize];

                fileInputStream.read(buffer1);

                for (int i = 0; i < bufferSize  ; i++) {
                    buffer2[i] = buffer1[bufferSize - i - 1];
                }

                fileOutputStream.write(buffer2);
            }

            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
