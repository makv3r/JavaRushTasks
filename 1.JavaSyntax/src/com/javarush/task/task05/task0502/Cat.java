package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        if (this.strength > anotherCat.strength) return true;
        else if (this.strength < anotherCat.strength) return false;
        else {
            if (this.weight > anotherCat.weight) return true;
            else if (this.weight < anotherCat.weight) return false;
            else {
                if (this.age > anotherCat.age) return true;
                else if (this.age < anotherCat.age) return false;
                else return true;
            }
        }
    }

    public static void main(String[] args) {

    }
}
