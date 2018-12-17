package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new Thread1("Thread 1"));
        threads.add(new Thread2("Thread 2"));
        threads.add(new Thread3("Thread 3"));
        threads.add(new Thread4("Thread 4"));
        threads.add(new Thread5("Thread 5"));
    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static class Thread1 extends Thread {
        public Thread1(String name) {
            super(name);
        }

        public void run() {
            while (true) {
            }
        }
    }

    public static class Thread2 extends Thread {
        public Thread2(String name) {
            super(name);
        }

        public void run() {
            try {
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class Thread3 extends Thread {
        public Thread3(String name) {
            super(name);
        }

        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }

    }

    public static class Thread4 extends Thread implements Message {
        public Thread4(String name) {
            super(name);
        }

        public void run() {
            while (!isInterrupted()) {}
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread {
        public Thread5(String name) {
            super(name);
        }

        public void run() {
            int sum = 0;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String input;
                while (!(input = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(input);
                }
                reader.close();

                System.out.println(sum);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}