package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");//2013-08-18
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM dd, yyyy");//AUG 18, 2013
        Date date = simpleDateFormat1.parse(reader.readLine());

        String s = simpleDateFormat2.format(date);

        System.out.println(s.toUpperCase());
    }
}
