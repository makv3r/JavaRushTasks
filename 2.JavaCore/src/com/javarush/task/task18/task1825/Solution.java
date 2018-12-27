package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {
        try {
            List<String> parts = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = null;
            while (!(fileName = reader.readLine()).equals("end")) {
                parts.add(fileName);
            }

            //parts.add("/home/thunder/Downloads/file1.txt.part1");
            //parts.add("/home/thunder/Downloads/file1.txt.part2");
            //parts.add("/home/thunder/Downloads/file1.txt.part3");

            Collections.sort(parts);
            String outputFile = parts.get(0).substring(0, parts.get(0).indexOf(".part"));
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile);

            for (String part : parts) {
                FileInputStream fileInputStream = new FileInputStream(part);
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
                fileInputStream.close();
            }

            fileOutputStream.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
