package ru.geekbrains.lesson2;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException() {
        super("Не верная длина массива");

    }

}
