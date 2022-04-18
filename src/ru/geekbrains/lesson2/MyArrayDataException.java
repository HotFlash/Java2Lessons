package ru.geekbrains.lesson2;

public class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(String m) {
        super("Не верные данные в строке! \n" + m);
    }
}
