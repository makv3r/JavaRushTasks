package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("LastName1","FirstName1");
        hashMap.put("LastName2","FirstName2");
        hashMap.put("LastName3","FirstName3");
        hashMap.put("LastName4","FirstName4");
        hashMap.put("LastName5","FirstName5");
        hashMap.put("LastName6","FirstName6");
        hashMap.put("LastName7","FirstName7");
        hashMap.put("LastName8","FirstName7");
        hashMap.put("LastName9","FirstName9");
        hashMap.put("LastName9","FirstName9");


        return hashMap;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
