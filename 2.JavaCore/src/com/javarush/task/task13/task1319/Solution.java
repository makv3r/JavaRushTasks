package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(reader.readLine())));
        List<String> list = new ArrayList<>();

        String s = "";
        do {
            s = reader.readLine();
            list.add(s);
        } while (!s.equals("exit"));

        for (String tmp : list) {
            writer.write(tmp + "\n");
        }

        reader.close();
        writer.close();

    }
}
