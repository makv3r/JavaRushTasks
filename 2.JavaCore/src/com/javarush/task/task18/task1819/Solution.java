package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String file1 = reader.readLine();
            String file2 = reader.readLine();

            //String file1 = "/home/thunder/Downloads/file1.txt";
            //String file2 = "/home/thunder/Downloads/file2.txt";

            FileInputStream fileInputStream1 = new FileInputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2);

            byte[] buffer1 = readFile(fileInputStream1);
            byte[] buffer2 = readFile(fileInputStream2);

            fileInputStream1.close();
            fileInputStream2.close();

            FileOutputStream fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(buffer2);
            fileOutputStream.write(buffer1);

            fileOutputStream.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] readFile(FileInputStream fileInputStream) throws IOException {
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        return buffer;
    }
}
