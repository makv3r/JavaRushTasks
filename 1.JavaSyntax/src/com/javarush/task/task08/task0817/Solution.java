package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> hashMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            hashMap.put("LastName" + i, "FirstName");
        }

        return hashMap;
    }
/*
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashMap<String, String> copy1 = new HashMap<>(map);
        HashMap<String, String> copy2 = new HashMap<>(map);

        for (HashMap.Entry<String, String> pair1 : copy1.entrySet()) {
            for (HashMap.Entry<String, String> pair2 : copy2.entrySet()) {
                if (!pair1.getKey().equals(pair2.getKey()) &&
                        pair1.getValue().equals(pair2.getValue())) {
                    removeItemFromMapByValue(map, pair1.getValue());
                }
            }
        }
    }
*/


    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        HashSet<String> hashSet = new HashSet<>();

        Iterator<HashMap.Entry<String,String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            HashMap.Entry<String,String> entry1 = iterator1.next();
            String tmpKey1 = entry1.getKey();
            String tmpValue1 = entry1.getValue();

            Iterator<HashMap.Entry<String,String>> iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext()) {
                HashMap.Entry<String,String> entry2 = iterator2.next();
                String tmpKey2 = entry2.getKey();
                String tmpValue2 = entry2.getValue();
                if (!tmpKey1.equals(tmpKey2) && tmpValue1.equals(tmpValue2)) {
                    hashSet.add(tmpValue1);
                    break;
                }
            }
        }

        for (String tmp : hashSet) {
            removeItemFromMapByValue(map, tmp);
        }
    }

/*
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>(map.values());
        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equals(arrayList.get(j))) {
                    hashSet.add(arrayList.get(i));
                    break;
                }
            }
        }

        for (String tmp : hashSet) {
            removeItemFromMapByValue(map, tmp);
        }
    }*/

/*
    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        ArrayList<String> arrayList = new ArrayList<String>(map.values());
        HashSet<String> hashSet = new HashSet<>();

        int count;
        for (String tmp1 : arrayList) {
            count = 0;
            for (String tmp2 : arrayList) {
                if (tmp1.equals(tmp2)) count++;
                if (count > 1) {
                    //removeItemFromMapByValue(map, tmp1);
                    hashSet.add(tmp1);
                    break;
                }
            }
        }

        for (String tmp : hashSet) {
            removeItemFromMapByValue(map, tmp);
        }
    }*/

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) throws Exception {
        HashMap<String,String> hashMap = createMap();

        removeTheFirstNameDuplicates(hashMap);
/*
        for (HashMap.Entry<String,String> tmp : hashMap.entrySet()) {
            System.out.println(tmp.getKey() + " " + tmp.getValue());
        }*/
    }
}
