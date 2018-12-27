package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");

            int count = 0;
            int bufferSize = fileInputStream.available();

            if (bufferSize > 0) {
                byte[] buffer = new byte[bufferSize];
                fileInputStream.read(buffer);

                for (int i = 0; i < buffer.length; i++) {// (65 && 90) || (97 && 122)
                    if ((buffer[i] >= 65 && buffer[i] <= 90) || (buffer[i] >= 97 && buffer[i] <= 122)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
