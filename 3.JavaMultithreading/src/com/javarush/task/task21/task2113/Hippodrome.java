package com.javarush.task.task21.task2113;

import java.util.*;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.stream()
                .max(Comparator.comparing(Horse::getDistance))
                .orElseThrow(NoSuchElementException::new);
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> list = new ArrayList<>();
        list.add(new Horse("H1", 3, 0));
        list.add(new Horse("H2", 3, 0));
        list.add(new Horse("H3", 3, 0));

        Hippodrome.game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }
}
