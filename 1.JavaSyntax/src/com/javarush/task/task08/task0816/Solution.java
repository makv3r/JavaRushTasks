package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));

        //напишите тут ваш код

        for (int i = 0; i < 9; i++) {
            map.put("Name" + i, df.parse("AUGUST " + i + " 199" + i));
        }

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код

        Iterator<HashMap.Entry<String,Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth();
            if (month == 5 || month == 6 || month == 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
