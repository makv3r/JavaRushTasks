package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        //FileInputStream fileInputStream = new FileInputStream("/home/thunder/Downloads/file1.txt");
        TreeSet<Integer> treeSet = new TreeSet<>();

        while (fileInputStream.available() > 0) {
            treeSet.add(fileInputStream.read());
        }
        fileInputStream.close();

        for (Integer tmp : treeSet) {
            System.out.print(tmp + " ");
        }
    }
}
