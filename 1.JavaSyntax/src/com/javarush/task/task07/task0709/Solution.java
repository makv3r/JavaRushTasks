package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int length = 0;

        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
            if (length > list.get(i).length() ||  length == 0) length = list.get(i).length();
        }

        for (int i = 0; i < list.size(); i++) {
            if (length == list.get(i).length()) System.out.println(list.get(i));
        }
    }
}
