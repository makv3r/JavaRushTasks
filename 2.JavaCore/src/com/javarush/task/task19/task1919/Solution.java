package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> treeMap = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        while (fileReader.ready()) {
            String data[] = fileReader.readLine().split(" ");
            double value = Double.parseDouble(data[1]);
            if (!treeMap.containsKey(data[0])) treeMap.put(data[0], value);
            else treeMap.put(data[0], treeMap.get(data[0]) + value);
        }
        fileReader.close();

        for (Map.Entry<String, Double> pair : treeMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}