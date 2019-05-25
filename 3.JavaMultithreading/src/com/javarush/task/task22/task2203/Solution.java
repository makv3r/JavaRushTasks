package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }

        int startIndex = string.indexOf('\t');
        int finishIndex = string.indexOf('\t', string.indexOf('\t') + 1);

        if (startIndex < 0 || finishIndex < 0) {
            throw new TooShortStringException();
        }

        return string.substring(startIndex + 1, finishIndex);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
