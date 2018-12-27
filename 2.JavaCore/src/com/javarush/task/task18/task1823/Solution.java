package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String name = null;
            while(!(name = reader.readLine()).equals("exit")) {
                new ReadThread(name).start();
            }

            reader.close();
/**
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);

                if (fileInputStream.available() > 0) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    fileInputStream.close();

                    int maxCount = 0;
                    int maxByte = 0;
                    for (int i = 0; i < buffer.length; i++) {
                        int count = 0;
                        for (int j = i; j < buffer.length; j++) {
                            if (buffer[i] == buffer[j]) count++;
                        }
                        if (count > maxCount) {
                            maxCount = count;
                            maxByte = buffer[i];
                        }
                    }

                    synchronized (resultMap) {
                        resultMap.put(fileName, maxByte);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
