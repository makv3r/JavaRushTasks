package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        //System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17})));
        //System.out.println(Arrays.asList(sort(new Integer[]{13, 8, 15, 5, 17, 11})));
        //System.out.println(Arrays.asList(sort(new Integer[]{1, 2, 3, 3, 3, 4, 5})));
        //System.out.println(Arrays.asList(sort(new Integer[]{1, 2, 4, 4, 4, 5})));
        //System.out.println(Arrays.asList(sort(new Integer[]{2, 3})));
        //System.out.println(Arrays.asList(sort(new Integer[]{0})));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        Arrays.sort(array);
        int mediana = array.length % 2 == 0 ?
                (array[array.length / 2] + array[array.length / 2 - 1]) / 2 :
                array[array.length / 2];

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - mediana) - Math.abs(o2 - mediana);
            }
        };

        Arrays.sort(array, comparator);
        return array;
    }
}
