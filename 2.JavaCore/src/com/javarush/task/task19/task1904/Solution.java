package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if (fileScanner.hasNext()) {
                String[] parts = fileScanner.nextLine().split(" ");

                Calendar calendar = new GregorianCalendar(
                        Integer.parseInt(parts[5]),
                        Integer.parseInt(parts[4]) - 1,
                        Integer.parseInt(parts[3])
                );

                person = new Person(parts[1], parts[2], parts[0], calendar.getTime());
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
