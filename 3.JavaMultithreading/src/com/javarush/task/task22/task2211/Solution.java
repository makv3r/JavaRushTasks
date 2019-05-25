package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        FileOutputStream fos = new FileOutputStream(args[1]);

        byte[] buffer = new byte[fis.available()];

        fis.read(buffer);
        fos.write(new String(buffer, "Windows-1251").getBytes("UTF-8"));

        fis.close();
        fos.close();
    }
}
