package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

    private static int N;
    private static int[] digitsMultiSet;
    private static int[] testMultiSet;

    private static TreeSet<Long> results;

    private static long maxPow;
    private static long minPow;
    private static long[][] pows;

    private static void genPows(int N) {
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }

    private static boolean check(long pow) {
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;

        for (int i = 0; i < 10; i++) {
            testMultiSet[i] = 0;
        }

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            if (testMultiSet[i] > digitsMultiSet[i]) return false;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
        }

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        if (pow >= maxPow) return;

        if (digit == -1) {
            if (check(pow)) results.add(pow);
            return;
        }

        if (digit == 0) {
            digitsMultiSet[digit] = unused;
            search(digit - 1, 0, pow + unused * pows[digit][N]);
        } else {
            if (pow + unused * pows[digit][N] < minPow) return;

            long p = pow;
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit - 1, unused - i, p);
                if (i != unused) {
                    p += pows[digit][N];
                }
            }
        }
    }

    public static long[] getNumbers(long number) {
        N = 0;
        results = new TreeSet<>();
        digitsMultiSet = new int[10];
        testMultiSet = new int[10];

        int maxN = (number <= 1) ? 1 : (int) Math.ceil(Math.log10(number));
        genPows(maxN);

        for (N = 1; N <= maxN; N++) {
            minPow = (long) Math.pow(10, N - 1);
            maxPow = (long) Math.pow(10, N);
            search(9, N, 0);
        }

        return results.stream()
                .mapToLong(l -> l)
                .filter(l -> l < number)
                .toArray();
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long[] result = getNumbers(Long.MAX_VALUE);
        long end = System.currentTimeMillis();

        System.out.println("time   = " + (end - start) + " ms");
        System.out.println("result = " + Arrays.toString(result));
    }
}
