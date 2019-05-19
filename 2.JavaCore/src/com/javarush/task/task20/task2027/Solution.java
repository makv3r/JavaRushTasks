package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

/*
Ожидаемый результат
home - (5, 3)h - (2, 0)e
same - (1, 1)s - (4, 1)e
 */

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        //List<Word> words = detectAllWords(crossword, "home", "same");
        List<Word> words = detectAllWords(crossword, "leo", "rre");

        for (Word word : words) {
            System.out.println(word);
        }

    }

    private static Word checkNE(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY - 1;

        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y < 0) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x--;
            y--;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x + 1, y + 1);
        return word;
    }

    private static Word checkN(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY - 1;

        for (int i = 1; i < s.length(); i++) {
            if (y < 0) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            y--;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x, y + 1);
        return word;
    }

    private static Word checkNW(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY - 1;

        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y < 0) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x++;
            y--;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x - 1, y + 1);
        return word;
    }

    private static Word checkE(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY;

        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x++;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x - 1, y);
        return word;
    }

    private static Word checkSE(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY + 1;

        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y >= crossword.length) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x++;
            y++;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x - 1, y - 1);
        return word;
    }

    private static Word checkS(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY + 1;

        for (int i = 1; i < s.length(); i++) {
            if (y >= crossword.length) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            y++;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x, y - 1);
        return word;
    }

    private static Word checkSW(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY + 1;

        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword.length) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x--;
            y++;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x + 1, y - 1);
        return word;
    }

    private static Word checkW(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY;

        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword[0].length) return null;
            if ((char) crossword[y][x] != s.charAt(i)) return null;
            x--;
        }

        Word word = new Word(s);
        word.setStartPoint(startX, startY);
        word.setEndPoint(x + 1, y);
        return word;
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> result = new ArrayList<>();

        for (String word : words) {
            char latter = word.charAt(0);

            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {

                    if ((char) crossword[i][j] == latter) {
                        int startX = j;
                        int startY = i;

                        Word[] array = new Word[8];

                        array[0] = checkNE(crossword, startX, startY, word);
                        array[1] = checkN(crossword, startX, startY, word);
                        array[2] = checkNW(crossword, startX, startY, word);
                        array[3] = checkE(crossword, startX, startY, word);
                        array[4] = checkSE(crossword, startX, startY, word);
                        array[5] = checkS(crossword, startX, startY, word);
                        array[6] = checkSW(crossword, startX, startY, word);
                        array[7] = checkW(crossword, startX, startY, word);

                        for (int k = 0; k < array.length; k++) {
                            if (array[k] != null) {
                                result.add(array[k]);
                            }
                        }

                    }
                }
            }
        }

        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
