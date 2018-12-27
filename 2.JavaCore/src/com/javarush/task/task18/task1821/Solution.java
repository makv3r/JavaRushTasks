package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");

            Map<Byte, Integer> map = new TreeMap<>();

            while (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);

                for (int i = 0; i < buffer.length; i++) {
                    map.put(buffer[i], (map.containsKey(buffer[i]) ? map.get(buffer[i]) + 1 : 1 ));
                }
            }

            for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                System.out.println((char)((byte) entry.getKey()) + " " + entry.getValue());
            }

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
