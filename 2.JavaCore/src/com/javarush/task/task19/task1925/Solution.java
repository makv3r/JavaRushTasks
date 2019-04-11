package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));

        StringBuffer stringBuffer = new StringBuffer();
        while (fileReader.ready()) {
            String words[] = fileReader.readLine().split(" ");
            for (String word : words) {
                if (word.length() > 6) stringBuffer.append(word).append(',');
            }
        }

        stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
        fileWriter.write(stringBuffer.toString());

        fileReader.close();
        fileWriter.close();
    }
}
