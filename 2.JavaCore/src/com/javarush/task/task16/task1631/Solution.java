package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class Solution {
    public static void main(String[] args) {
        ImageReader reader1 = ImageReaderFactory.getImageReader(ImageTypes.JPG);
        ImageReader reader2 = ImageReaderFactory.getImageReader(ImageTypes.PNG);
        ImageReader reader3 = ImageReaderFactory.getImageReader(ImageTypes.BMP);
        ImageReader reader4 = ImageReaderFactory.getImageReader(null);
        System.out.println(reader1);
        System.out.println(reader2);
        System.out.println(reader3);
        System.out.println(reader4);
    }
}
