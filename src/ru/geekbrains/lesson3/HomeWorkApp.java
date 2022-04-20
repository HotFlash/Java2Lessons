package ru.geekbrains.lesson3;

import java.util.*;

public class HomeWorkApp {
    public static void main(String[] args) {
        Phones book = new Phones();
        book.add("Виктор", "123");
        book.add("Валерий", "1234");
        book.add("Виктор", "1230987");
        book.add("Антон", "765456");
        book.add("Максим", "232342342432");

        Set<String> names = book.allNames();
        for (String name : names) {
            System.out.println("Имя: " + name + " - номер: " + book.get(name));
        }
    }
}
