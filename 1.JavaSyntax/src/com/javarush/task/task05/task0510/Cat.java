package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код

    private String name;
    private int weight;
    private int age;
    private String color;
    private String address;

    public void initialize(String name) {
        this.name = name;
        this.weight = 1;
        this.age = 1;
        this.color = "white";

    }
    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "white";
    }
    public void initialize(String name, int age) {
        this.name = name;
        this.weight = 1;
        this.age = age;
        this.color = "white";
    }
    public void initialize(int weight, String color) {
        this.weight = weight;
        this.age = 1;
        this.color = color;
    }
    public void initialize(int weight, String color, String address) {
        this.weight = weight;
        this.age = 1;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
