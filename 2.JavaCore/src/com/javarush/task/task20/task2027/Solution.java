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

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();

        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (String word : words) {
            for (int row = 0; row < crossword.length; row++) {
                for (int col = 0; col < crossword[row].length; col++) {
                    if ((char) crossword[row][col] == word.charAt(0)) {

                        for (int dir = 0; dir < 8; dir++) {
                            int k;
                            int rd = row + x[dir];
                            int cd = col + y[dir];

                            for (k = 1; k < word.length(); k++) {
                                if (rd >= crossword.length || rd < 0 || cd >= crossword[0].length || cd < 0) break;
                                if (crossword[rd][cd] != word.charAt(k)) break;
                                rd += x[dir];
                                cd += y[dir];
                            }

                            if (k == word.length()) {
                                Word element = new Word(word);
                                element.setStartPoint(col, row);
                                element.setEndPoint(cd - y[dir], rd - x[dir]);
                                result.add(element);
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
