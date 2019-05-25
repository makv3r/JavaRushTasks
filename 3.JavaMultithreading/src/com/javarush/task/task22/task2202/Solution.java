package com.javarush.task.task22.task2202;


/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null ||
                string.isEmpty() ||
                string.trim().chars().filter(c -> c == ' ').count() < 4) {
            throw new TooShortStringException();
        }

        String[] s = string.split(" ");

        return s[1] + " " + s[2] + " " + s[3] + " " + s[4];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
