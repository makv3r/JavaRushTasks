package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.*;


/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (ArithmeticException e) { //java.lang.ArithmeticException: / by zero
            exceptions.add(e);
        }

        //напишите тут ваш код

        try {
            List<String> list = null;
            list.add("s");
        } catch (NullPointerException e) { //java.lang.NullPointerException
            exceptions.add(e);
        }

        try {
            int[] x = new int[10];
            System.out.println(x[10]);
        } catch (ArrayIndexOutOfBoundsException e) { //java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
            exceptions.add(e);
        }

        try {
            File file = new File("./tmp.txt");
            FileInputStream inputStream = new FileInputStream(file);
            if (inputStream != null) inputStream.close();
        } catch (IOException e) { //java.io.FileNotFoundException: ./tmp.txt (No such file or directory)
            exceptions.add(e);
        }

        try {
            new Long("ZDF");
        } catch (NumberFormatException e) { //java.lang.NumberFormatException: For input string: "ZDF"
            exceptions.add(e);
        }

        try {
            Object o = new Integer(10);
            System.out.println((String) o);
        } catch (ClassCastException e) { //java.lang.ClassCastException:*
            exceptions.add(e);
        }

        try {
            Object o[] = new String[5];
            o[2] = new Integer(200);
        } catch (ArrayStoreException e) { //java.lang.ArrayStoreException: java.lang.Integer
            exceptions.add(e);
        }

        try {
            int[] x = new int[-5];
        } catch (NegativeArraySizeException e) { //java.lang.NegativeArraySizeException: -5
            exceptions.add(e);
        }

        try {
            String s = "1234567890";
            System.out.println(s.charAt(11));
        } catch (StringIndexOutOfBoundsException e) { //java.lang.StringIndexOutOfBoundsException: String index out of range: 11
            exceptions.add(e);
        }

        try {
            Stack stack = new Stack();
            System.out.println(stack.pop());
        } catch (EmptyStackException e) { //java.util.EmptyStackException
            exceptions.add(e);
        }
    }
}
