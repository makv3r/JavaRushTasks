package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("JAN 3 2018"));
    }

    public static boolean isDateOdd(String date) {
        Date yearStartTime = new Date(date);
        Date currentTime = new Date(date);
        yearStartTime.setMonth(0);
        yearStartTime.setDate(1);
        yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);

        long daysBetween = (currentTime.getTime()-yearStartTime.getTime())/(3600*24*1000)+1;

        return (daysBetween % 2 != 0 ? true : false);
    }

}
