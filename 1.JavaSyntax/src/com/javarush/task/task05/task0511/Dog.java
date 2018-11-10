package com.javarush.task.task05.task0511;

/* 
Создать класс Dog
*/

public class Dog {
    //напишите тут ваш код
    // У класса Dog должна быть переменная name с типом String.
    //3. У класса Dog должна быть переменная height с типом int.
    //4. У класса Dog должна быть переменная color с типом String.

    private String name;
    private int height;
    private String color;

    public void initialize (String name) {
        this.name = name;
    }
    public void initialize (String name, int height) {
        this.name = name;
        this.height = height;
    }
    public void initialize (String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
