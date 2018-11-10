package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        Human Children1 = new Human("Children1",true, 10, null);
        Human Children2 = new Human("Children2",true, 11, null);
        Human Children3 = new Human("Children3",true, 12, null);

        Human Father = new Human("Father",true, 30, new ArrayList<Human>(){{add(Children1);add(Children2);add(Children3);}});
        Human Mother = new Human("Mother",false, 28, new ArrayList<Human>(){{add(Children1);add(Children2);add(Children3);}});

        Human GrandPa1 = new Human("GrandPa1",true, 80, new ArrayList<Human>(){{add(Father);}});
        Human GrandPa2 = new Human("GrandPa2",true, 80, new ArrayList<Human>(){{add(Mother);}});

        Human GrandBa1 = new Human("GrandBa1",false, 78, new ArrayList<Human>(){{add(Father);}});
        Human GrandBa2 = new Human("GrandBa2",false, 78, new ArrayList<Human>(){{add(Mother);}});

        ArrayList<Human> people = new ArrayList<>();
        people.add(Children1);
        people.add(Children2);
        people.add(Children3);
        people.add(Father);
        people.add(Mother);
        people.add(GrandPa1);
        people.add(GrandPa2);
        people.add(GrandBa1);
        people.add(GrandBa2);

        for (Human tmp : people) {
            System.out.println(tmp.toString());
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        Human (String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (children != null) this.children = new ArrayList<>(children);
            else this.children = new ArrayList<>();
            //this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
