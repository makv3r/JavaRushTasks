package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            return Arrays.stream(comparators)
                    .reduce((t1, t2) -> 0, Comparator::thenComparing)
                    .compare(o1, o2);
        }
    }


    public static void main(String[] args) {

    }
}
