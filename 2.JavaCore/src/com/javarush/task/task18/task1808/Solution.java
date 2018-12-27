package com.javarush.task.task18.task1808;

/* 
Разделение файла
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
            FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
            FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());

            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");
            //FileOutputStream fileOutputStream1 = new FileOutputStream("/home/thunder/Downloads/file2.txt");
            //FileOutputStream fileOutputStream2 = new FileOutputStream("/home/thunder/Downloads/file3.txt");

            int bufferSize = fileInputStream.available();
            if (bufferSize > 0) {
                int part1Size = bufferSize % 2 == 0 ? bufferSize / 2 : bufferSize / 2 + 1;
                int part2Size = bufferSize - part1Size;

                byte[] buffer1 = new byte[part1Size];
                byte[] buffer2 = new byte[part2Size];

                fileInputStream.read(buffer1);
                fileInputStream.read(buffer2);

                fileOutputStream1.write(buffer1);
                fileOutputStream2.write(buffer2);
            }

            fileInputStream.close();
            fileOutputStream1.close();
            fileOutputStream2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
