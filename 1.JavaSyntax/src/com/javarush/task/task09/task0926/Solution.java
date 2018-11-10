package com.javarush.task.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> arrayList = new ArrayList<>();

        /*
        ArrayList<Integer> max = new ArrayList<>(Arrays.asList(5, 2, 4, 7, 0));

        for (int i = 0; i < max.size(); i++) {
            int[] data = new int[max.get(i)];
            for (int j = 0; j < max.get(i); j++) {
                data[j] = (int)(Math.random() * 10);
            }
            if (max.get(i) == 0) {
                arrayList.add(new int[]{});
                continue;
            }
            arrayList.add(data);
        }*/

        arrayList.add(new int[]{0,1,2,3,4});
        arrayList.add(new int[]{0,1});
        arrayList.add(new int[]{0,1,2,3});
        arrayList.add(new int[]{0,1,2,3,4,5,6});
        arrayList.add(new int[]{});
        //5, 2, 4, 7, 0

        return arrayList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
