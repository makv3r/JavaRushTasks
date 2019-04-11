package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String file1 = "/home/thunder/java/Filework/file1.txt";
        //String file2 = "/home/thunder/java/Filework/file2.txt";
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));

        List<String> fileData1 = new BufferedReader(fileReader1).lines().collect(Collectors.toList());
        List<String> fileData2 = new BufferedReader(fileReader2).lines().collect(Collectors.toList());

        fileReader1.close();
        fileReader2.close();

        while (fileData1.size() != 0 & fileData2.size() != 0) {
            if (fileData1.get(0).equals(fileData2.get(0))) {
                lines.add(new LineItem(Type.SAME, fileData1.remove(0)));
                fileData2.remove(0);
            } else if (fileData2.size() != 1 && fileData1.get(0).equals(fileData2.get(1))) {
                lines.add(new LineItem(Type.ADDED, fileData2.remove(0)));
            } else if (fileData1.size() != 1 && fileData1.get(1).equals(fileData2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, fileData1.remove(0)));
            }
        }

        if (fileData1.size() != 0) {
            lines.add(new LineItem(Type.REMOVED, fileData1.remove(0)));
        } else if (fileData2.size() != 0) {
            lines.add(new LineItem(Type.ADDED, fileData2.remove(0)));
        }

        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
