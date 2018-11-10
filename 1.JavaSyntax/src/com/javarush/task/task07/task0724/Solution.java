package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        // объекта без отца и матери и 5 объектов с ними)).
        //6. Выведи созданные объекты на экран.
        Human human1 = new Human("Human1Name",true,20);
        Human human2 = new Human("Human2Name",false,20);
        Human human3 = new Human("Human3Name",true,20);
        Human human4 = new Human("Human4Name",false,20);

        Human human5 = new Human("Human5Name",true,20, human1, human2);
        Human human6 = new Human("Human6Name",false,20, human3, human4);
        Human human7 = new Human("Human7Name",true,20, human1, human2);
        Human human8 = new Human("Human8Name",false,20, human3, human4);
        Human human9 = new Human("Human9Name",true,20, human1, human2);

        System.out.println(human1.toString());
        System.out.println(human2.toString());
        System.out.println(human3.toString());
        System.out.println(human4.toString());
        System.out.println(human5.toString());
        System.out.println(human6.toString());
        System.out.println(human7.toString());
        System.out.println(human8.toString());
        System.out.println(human9.toString());

    }

    public static class Human {
        //напишите тут ваш код
        //имя(String), пол(boolean), возраст(int), отец(Human), мать(Human)
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















