package com.javarush.task.task15.task1513;

/* 
Максимально простой код-3
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine implements Runnable { //extends Object
        /*public Machine() {
            super();
        }*/
    }

    public class Car extends Machine { //implements Runnable
        /*public Car() {
            super();
        }*/
    }
}
