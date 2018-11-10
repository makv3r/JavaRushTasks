package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        //FileInputStream inputStream = new FileInputStream("/home/thunder/java/test.txt");
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));

        List<Integer> list = new ArrayList<>();

        while (fileReader.ready()) {
            list.add(Integer.parseInt(fileReader.readLine()));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 != 0) {
                list.remove(i);
                i--;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)) { // swap
                    int tmp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,tmp);
                }
            }
        }

        for (int tmp : list) {
            System.out.println(tmp);
        }

        fileReader.close();
        inputStream.close();
        reader.close();
    }
}
