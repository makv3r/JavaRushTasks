package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s.trim();
        String[] words = s.split("\\s+");

        //напишите тут ваш код

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) words[i] = word.substring(0, 1).toUpperCase();
            if (word.length() > 1) words[i] += word.substring(1);
        }

        s = String.join(" ", words);

        System.out.println(s);
    }
}
