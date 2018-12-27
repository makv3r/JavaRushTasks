package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            //File file1 = new File("/home/thunder/Downloads/file1.txt");
            //File file2 = new File("/home/thunder/Downloads/file2.txt");
            File file1 = new File(reader.readLine());
            File file2 = new File(reader.readLine());

            allLines = readFileToList(file1);
            forRemoveLines = readFileToList(file2);

            new Solution().joinData();

        } catch (Exception e) {
            e.printStackTrace();
        }
/**
        for (String tmp : allLines) { // Test
            System.out.println(tmp);
        }
*/
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

    public static List<String> readFileToList(File file) {
        List<String> list = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
