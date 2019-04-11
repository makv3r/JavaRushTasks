package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

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

        double max = treeMap.firstEntry().getValue();
        for (Double number : treeMap.values()) {
            if (max < number) max = number;
        }

        for (Map.Entry<String, Double> pair : treeMap.entrySet()) {
            if (pair.getValue().equals(max)) System.out.println(pair.getKey());
        }
    }
}
