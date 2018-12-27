package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");
            //FileOutputStream fileOutputStream = new FileOutputStream("/home/thunder/Downloads/file2.txt");

            String[] array = new String(readFile(fileInputStream)).split(" ");
            StringBuilder sb = new StringBuilder();

            for (String tmp : array) {
                try {
                    sb.append((int) Math.round(Double.parseDouble(tmp)));
                    sb.append(" ");
                } catch (NumberFormatException e) {}
            }

            fileOutputStream.write(sb.toString().getBytes());

            fileInputStream.close();
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
