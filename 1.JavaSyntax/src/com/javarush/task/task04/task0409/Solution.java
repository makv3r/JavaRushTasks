package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(7, 14);
    }

    public static void closeToTen(int a, int b) {
        //напишите тут ваш код
        int x = abs(a - 10);
        int y = abs(b - 10);

        if (x == y) System.out.println(a);
        else if (x < y) System.out.println(a);
        else System.out.println(b);
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}