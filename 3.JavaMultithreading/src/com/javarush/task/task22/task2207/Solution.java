package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

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

        List<String> list = new ArrayList<>(Arrays.asList(stringBuilder.toString().split(" ")));
        for (int i = 0; i < list.size(); i++) {
            String baseWord = list.get(i);
            if (baseWord.length() > 0 && !baseWord.contains(" ")) {
                String reverseWord = new StringBuilder(baseWord).reverse().toString();
                for (int j = i + 1; j < list.size(); j++) {
                    if (reverseWord.equals(list.get(j))) {
                        Pair pair = new Pair();
                        pair.first = list.get(j);
                        pair.second = baseWord;
                        result.add(pair);
                        list.remove(i);
                        j--;
                        list.remove(j);
                        i--;
                        break;
                    }
                }
            }
        }

/*
        String[] array = stringBuilder.toString().split(" ");

        for (int i = 0; i < array.length; i++) {
            stringBuilder.setLength(0);
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(stringBuilder.append(array[j]).reverse().toString())) {
                    Pair pair = new Pair();
                    pair.first = array[j];
                    pair.second = array[i];

                    if (!result.contains(pair)) {
                        result.add(pair);
                        break;
                    }
                }
            }
        }
*/
        printResult();

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

    private static void printResult() {
        for (Pair pair : result) {
            System.out.println(pair.first + " " + pair.second);
        }
    }

}
