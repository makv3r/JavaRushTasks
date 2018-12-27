package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            hashMap.put(data, (hashMap.containsKey(data) ? hashMap.get(data) + 1 : 1 ));
        }
        fileInputStream.close();

        //int minCount = Collections.min(hashMap.values());
        int minCount = 1;
        for (int value : hashMap.values()) {
            if (minCount > value) minCount = value;
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (minCount == entry.getValue()) System.out.print(entry.getKey() + " ");
        }

    }
}
