package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "/home/thunder/java/javarush/filework/tmp.txt";
        reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        while (reader.ready()) {
            stringBuilder.append(reader.readLine().trim()).append(" ");
        }

        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

        reader.close();

        String[] words = stringBuilder.toString().split(" ");
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        List<String> list = new ArrayList<>();
        List<String> buff = new LinkedList<>();

        for (String word : words) {
            if (list.size() == 0) {
                list.add(word);
            } else if (!list.contains(word)) {
                buff.add(0, word);
                boolean added;
                do {
                    added = false;

                    String firstWord = list.get(0);
                    String lastWord = list.get(list.size() - 1);

                    char firstWordFirstChar = firstWord.toLowerCase().charAt(0);
                    char lastWordLastChar = lastWord.toLowerCase().charAt(lastWord.length() - 1);

                    for (String string : buff) {
                        char stringFirstChar = string.toLowerCase().charAt(0);
                        char stringLastChar = string.toLowerCase().charAt(string.length() - 1);

                        if (stringLastChar == firstWordFirstChar) {
                            list.add(0, string);
                            added = true;
                            buff.remove(string);
                            break;
                        } else if (stringFirstChar == lastWordLastChar) {
                            list.add(string);
                            added = true;
                            buff.remove(string);
                            break;
                        } else if (stringFirstChar == stringLastChar) {
                            for (int i = 1; i < list.size(); i++) {
                                if (list.get(i).toLowerCase().charAt(0) == stringFirstChar) {
                                    list.add(i, string);
                                    buff.remove(string);
                                    break;
                                }
                            }
                        }
                    }
                } while (added);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String word : list) {
            stringBuilder.append(word).append(" ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }

        return stringBuilder;
    }
}
