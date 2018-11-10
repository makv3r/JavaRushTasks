package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;

        try {
            key = reader.readLine();
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        if (key.equals(thePlanet.SUN)) thePlanet = Sun.getInstance();
        else if (key.equals(thePlanet.MOON)) thePlanet = Moon.getInstance();
        else if (key.equals(thePlanet.EARTH)) thePlanet = Earth.getInstance();
        else thePlanet = null;
    }
}
