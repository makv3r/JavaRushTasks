package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] solutions = new Solution[2];

        for (int i = 0; i < solutions.length; i++) {
            solutions[i] = new Solution();
            solutions[i].innerClasses[0] = solutions[i].new InnerClass();
            solutions[i].innerClasses[1] = solutions[i].new InnerClass();
        }

        return solutions;
    }

    public static void main(String[] args) {

    }
}
