package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String file1 = "/home/thunder/Downloads/test.txt";
        //String file2 = "/home/thunder/Downloads/out.txt";

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] parts = line.split("\\s");

            for (String part : parts) {
                try {
                    int number = Integer.parseInt(part);
                    fileWriter.write(part + " ");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
