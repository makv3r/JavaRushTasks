package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String pet = "";

        if (o instanceof Cat) {
            if (o instanceof Tiger) pet = "Тигр";
            else if (o instanceof Lion) pet = "Лев";
            else pet = "Кот";
        }
        else if (o instanceof Animal) {
            if (o instanceof Bull) pet = "Бык";
            else if (o instanceof Cow) pet = "Корова";
            else pet = "Животное";
        }

        return pet;
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
