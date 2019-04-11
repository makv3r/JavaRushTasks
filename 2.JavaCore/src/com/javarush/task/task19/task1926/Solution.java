package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        //BufferedReader fileReader = new BufferedReader(new FileReader("/home/thunder/java/Filework/text.txt"));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            for (int i = line.length() - 1; i >= 0; i--) {
                System.out.print(line.charAt(i));
            }
            System.out.println();
        }

        fileReader.close();
        reader.close();
    }
}
