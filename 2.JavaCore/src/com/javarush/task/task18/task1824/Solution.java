package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String fileName = reader.readLine();
                try {
                    FileInputStream fileInputStream = new FileInputStream(fileName);
                    fileInputStream.close();
                } catch (FileNotFoundException e) {
                    System.out.println(fileName);
                    break;
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
