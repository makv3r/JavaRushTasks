package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());

        while (inputStream.available() > 0) {
            System.out.print((char)inputStream.read());
        }

        reader.close();
        inputStream.close();
    }
}