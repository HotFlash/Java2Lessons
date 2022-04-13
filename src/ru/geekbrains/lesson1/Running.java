package ru.geekbrains.lesson1;

public interface Running {
    int running();
    default int run(){
        return 100;
    }
}
