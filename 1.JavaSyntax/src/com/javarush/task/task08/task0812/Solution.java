package com.javarush.task.task08.task0812;

import javax.sound.midi.Sequence;
import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(reader.readLine()));
        }

        int max = 1;
        int tmp = 1;

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) tmp++;
            else {
                tmp = 1;
                continue;
            }

            if (max < tmp) max = tmp;
        }

        System.out.println(max);
    }
}