package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        Stack<Throwable> exceptions = new Stack<>();

        Throwable throwable = e;
        do {
            exceptions.push(throwable);
            throwable = throwable.getCause();
        }  while (throwable != null);

        while (!exceptions.empty()) {
            Throwable exception = exceptions.pop();
            System.out.println(String.format("%s: %s", exception.getClass().getName(), exception.getMessage()));
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(new Thread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
