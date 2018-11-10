package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();

            /*
            String s = "";
            for (int j = 0; j < 30; j++) {
                s += abc.charAt((int)(Math.random() * abc.length()));
            }*/

            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        ArrayList<Integer> countList = new ArrayList<>();//Create countList
        for (int i = 0; i < alphabet.size(); i++) { // Init countList
            countList.add(0);
        }

        for (String tmp : list) {
            for (int i = 0; i < tmp.length(); i++) {
                for (int j = 0; j < alphabet.size(); j++) {
                    if (alphabet.get(j).equals(tmp.charAt(i))) countList.set(j,countList.get(j) + 1);
                }
            }
        }

        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + countList.get(i));
        }
    }
}
