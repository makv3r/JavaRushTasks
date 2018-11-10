package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        int max = 0;
        int min = 0;

        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            if (max < list.get(i).length()) max = list.get(i).length();
            if (min > list.get(i).length() || min == 0) min = list.get(i).length();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == max) {
                System.out.println(list.get(i));
                break;
            }
            if (list.get(i).length() == min) {
                System.out.println(list.get(i));
                break;
            }
        }

    }
}
