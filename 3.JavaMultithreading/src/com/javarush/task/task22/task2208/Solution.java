package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(map);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                stringBuilder.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
            }
        }
        if (stringBuilder.length() > 5) {
            stringBuilder.setLength(stringBuilder.length() - 5);
        }
        return stringBuilder.toString();
    }
}
