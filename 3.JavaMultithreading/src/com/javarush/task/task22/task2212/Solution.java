package com.javarush.task.task22.task2212;

import java.util.HashMap;
import java.util.Map;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) return false;

        char firstChar = telNumber.charAt(0);
        char lastChar = telNumber.charAt(telNumber.length() - 1);

        boolean plus = firstChar == '+';

        int maxDigits = plus ? 12 : 10;
        int countDigits = 0;

        int hyphenFirstPosition = 0;
        int hyphenSecondPosition = 0;
        int hyphenCount = 0;

        int bracketStart = 0;
        int bracketEnd = 0;
        int bracketsCount = 0;

        for (int i = plus ? 1 : 0; i < telNumber.length(); i++) {
            if (isNumber(telNumber.charAt(i))) {
                countDigits++;
            } else if (telNumber.charAt(i) == '-') {
                if (hyphenCount == 0) {
                    hyphenFirstPosition = i;
                } else if (hyphenCount == 1) {
                    hyphenSecondPosition = i;
                }
                hyphenCount++;
            } else if (telNumber.charAt(i) == '(') {
                bracketStart = i;
                bracketsCount++;
            } else if (telNumber.charAt(i) == ')') {
                bracketEnd = i;
                bracketsCount++;
            } else {
                return false;
            }
        }

        if (maxDigits != countDigits
                || !isNumber(lastChar)
                || (bracketsCount != 0 && bracketsCount != 2)
                || (bracketEnd - bracketStart != 0 && bracketEnd - bracketStart != 4)
                || hyphenCount > 2
                || (hyphenCount == 2 && hyphenSecondPosition - hyphenFirstPosition == 1)
                || ((bracketsCount > 0 && hyphenCount > 0) && hyphenFirstPosition - bracketEnd < 0)
        ) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Map<String, Boolean> map = new HashMap<>();
        map.put("+380501234567", true);
        map.put("+38(050)1234567", true);
        map.put("+38050123-45-67", true);
        map.put("050123-4567", true);
        map.put("+38)050(1234567", false);
        map.put("+38(050)1--234567", false);
        map.put("+38(050)1-23-45-6-7", false);
        map.put("+38(050-)1-234567", false);
        map.put("+38(050)-23-45-6-7", false);
        map.put("050ххх4567", false);
        map.put("050123456", false);
        map.put("(0)501234567", false);

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            String phone = entry.getKey();
            boolean checked = checkTelNumber(phone);
            System.out.println(String.format("Equal : %5s | Excepted : %5s | Actual : %5s | Phone : %s",
                    entry.getValue() == checked,
                    entry.getValue(),
                    checked,
                    phone));
        }
    }

    private static boolean isNumber(char digit) {
        return digit >= '0' && digit <= '9';
    }
}

