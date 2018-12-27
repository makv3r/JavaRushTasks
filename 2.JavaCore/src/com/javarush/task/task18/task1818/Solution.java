package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
            FileInputStream fileInputStream1 = new FileInputStream(reader.readLine());
            FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());

            //FileOutputStream fileOutputStream = new FileOutputStream("/home/thunder/Downloads/file0.txt");
            //FileInputStream fileInputStream1 = new FileInputStream("/home/thunder/Downloads/file1.txt");
            //FileInputStream fileInputStream2 = new FileInputStream("/home/thunder/Downloads/file2.txt");

            fileOutputStream.write(readFile(fileInputStream1));
            fileOutputStream.write(readFile(fileInputStream2));

            fileOutputStream.close();
            fileInputStream2.close();
            fileInputStream1.close();
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
