package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
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

        //int maxCount = Collections.max(hashMap.values());
        int maxCount = 0;
        for (int value : hashMap.values()) {
            if (maxCount < value) maxCount = value;
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (maxCount == entry.getValue()) System.out.print(entry.getKey() + " ");
        }
    }
}
