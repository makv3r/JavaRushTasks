package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(short m, short n, Object value) {
        for (short i = 0; i < m; i++) {
            for (short j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double m, double n, Object value) {
        for (double i = 0; i < m; i++) {
            for (double j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(long m, long n, Object value) {
        for (long i = 0; i < m; i++) {
            for (long j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Integer m, Integer n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(Double m, Double n, Object value) {
        for (double i = 0; i < m; i++) {
            for (double j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(int m, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(double m, Object value) {
        for (double i = 0; i < m; i++) {
            for (double j = 0; j < m; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }

    public static void printMatrix(long m, Object value) {
        for (long i = 0; i < m; i++) {
            for (long j = 0; j < m; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
