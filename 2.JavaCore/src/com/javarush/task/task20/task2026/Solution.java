package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        byte[][] a4 = new byte[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        byte[][] a5 = new byte[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        byte[][] a6 = new byte[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 1");
        int count4 = getRectangleCount(a4);
        System.out.println("count = " + count4 + ". Должно быть 0");
        int count5 = getRectangleCount(a5);
        System.out.println("count = " + count5 + ". Должно быть 4");
        int count6 = getRectangleCount(a6);
        System.out.println("count = " + count6 + ". Должно быть 1");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;

        int[] row = new int[a.length * a[0].length];
        int[] col = new int[a.length * a[0].length];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for (int i = 0, index = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 1) {
                    row[index] = i;
                    col[index] = j;
                    index++;
                }
            }
        }

        if (row[0] != -1 || col[0] != -1) {
            count = 1;

            for (int i = 0; i < row.length - 1; i++) {
                if (row[i] == -1 || col[i] == -1 || row[i + 1] == -1 || col[i + 1] == -1) break;
                if ((row[i] < row[i + 1] && Math.abs(row[i] - row[i + 1]) > 1)
                        || (col[i] < col[i + 1] && Math.abs(col[i] - col[i + 1]) > 1)
                        || (row[i] == col[i] && row[i + 1] == col[i + 1])
                ) {
                    count++;
                }
            }

        }
        return count;
    }
}