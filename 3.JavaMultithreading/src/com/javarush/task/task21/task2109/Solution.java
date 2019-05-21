package com.javarush.task.task21.task2109;

import java.util.Objects;

/*
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            B b = (B) o;
            return Objects.equals(name, b.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "B{" +
                    "i=" + getI() +
                    ", j=" + getJ() +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }

        @Override
        public String toString() {
            return "C{" +
                    "i=" + getI() +
                    ", j=" + getJ() +
                    ", name='" + getName() + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        B b = new B(0, 0, "");
        try {
            B clone = (B) b.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        C c = new C(0, 0, "");
        try {
            C clone = (C) c.clone();

            System.out.println(c);
            System.out.println(clone);
            System.out.println(c.equals(clone));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
