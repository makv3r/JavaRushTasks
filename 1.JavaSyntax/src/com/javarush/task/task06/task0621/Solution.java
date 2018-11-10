package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Cat catGrandPa  = new Cat(reader.readLine());
        Cat catGrandMa  = new Cat(reader.readLine());
        Cat catFather   = new Cat(reader.readLine(), catGrandPa, null);
        Cat catMother   = new Cat(reader.readLine(), null, catGrandMa);
        Cat catSon      = new Cat(reader.readLine(), catFather, catMother);
        Cat catDaughter = new Cat(reader.readLine(), catFather, catMother);

/*
        Cat catGrandPa  = new Cat("GrandPa");
        Cat catGrandMa  = new Cat("GrandMa");
        Cat catFather   = new Cat("Father", catGrandPa, null);
        Cat catMother   = new Cat("Mother", null, catGrandMa);
        Cat catSon      = new Cat("Son", catFather, catMother);
        Cat catDaughter = new Cat("Daughter", catFather, catMother);
*/

        System.out.println(catGrandPa);
        System.out.println(catGrandMa);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        @Override
        public String toString() {
            String s = "The cat's name is " + this.name;
            if (mother == null) s += ", no mother";
            else s += ", mother is " + mother.name;

            if (father == null) s += ", no father";
            else s += ", father is " + father.name;

            return s;
        }
    }
}
