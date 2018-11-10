package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Calendar calendar = Calendar.getInstance();
        System.out.print (calendar.get(Calendar.DAY_OF_MONTH) + " " +
                         (calendar.get(Calendar.MONTH) + 1) + " " +
                          calendar.get(Calendar.YEAR));

    }
}
