package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String fileName = "/home/thunder/Downloads/test.txt";
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        int count = 0;
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] parts = line.split("\\W");

            for (String part: parts) {
                if (part.equals("world")) count++;
            }
        }

        fileReader.close();

        System.out.println(count);
    }
}
