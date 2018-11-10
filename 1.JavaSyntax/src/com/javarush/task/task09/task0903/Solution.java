package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        method2();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElement[2].getLineNumber());
        return /*напишите тут ваш код*/ stackTraceElement[2].getLineNumber();
    }

    public static int method2() {
        method3();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElement[2].getLineNumber());
        return /*напишите тут ваш код*/ stackTraceElement[2].getLineNumber();
    }

    public static int method3() {
        method4();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElement[2].getLineNumber());
        return /*напишите тут ваш код*/ stackTraceElement[2].getLineNumber();
    }

    public static int method4() {
        method5();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElement[2].getLineNumber());
        return /*напишите тут ваш код*/ stackTraceElement[2].getLineNumber();
    }

    public static int method5() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        //System.out.println(stackTraceElement[2].getLineNumber());
        return /*напишите тут ваш код*/ stackTraceElement[2].getLineNumber();
    }
}
