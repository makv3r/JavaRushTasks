package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    public static void main(String[] args) {

    }

    Solution () {}
    private Solution(int a) {}
    protected Solution(int a, int b) {}
    public Solution(int a, int b, int c) {}
}

