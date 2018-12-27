package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream fileInputStream = new FileInputStream(reader.readLine());
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");

            String[] array = new String(readFile(fileInputStream)).split("\n");

            for (String tmp : array) {
                if (tmp.startsWith(args[0] + " ")) System.out.println(tmp);
            }

            fileInputStream.close();
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
