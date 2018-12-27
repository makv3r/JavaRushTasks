package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) {
        try {
            if (args.length == 3 && ("-e".equals(args[0]) || "-d".equals(args[0]))) {
                xorFile(args[1], args[2]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void xorFile(String fileInput, String fileOutput) throws Exception {
        byte[] key = new byte[]{1, 2, 3, 4, 5};

        FileInputStream fileInputStream = new FileInputStream(fileInput);
        FileOutputStream fileOutputStream = new FileOutputStream(fileOutput);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();

        for (int i = 0, j = 0; i < buffer.length; i++, j++) {
            if (j == key.length) j = 0;
            buffer[i] = (byte) (buffer[i] ^ key[j]);
        }

        fileOutputStream.write(buffer);
        fileOutputStream.close();
    }
}
