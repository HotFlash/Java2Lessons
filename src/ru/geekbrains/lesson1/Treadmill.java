package ru.geekbrains.lesson1;

public class Treadmill implements Barriers{
    private final String name;
    private final int length;

    public Treadmill(String name, int length) {
        this.name = name;
        this.length = length;
    }



    public boolean areRun(Running ableToRun) {
        int runningDistance = ableToRun.running();
        return runningDistance >= length;
    }
}
