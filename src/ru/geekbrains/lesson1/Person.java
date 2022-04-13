package ru.geekbrains.lesson1;

public class Person implements Jumping, Running, Member{

    private String name;
    private int jumpHeight;
    private int runLenght;

    public Person(String name, int jumpHeight, int runLenght) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runLenght = runLenght;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public int getRunLenght() {
        return runLenght;
    }

    public void setRunLenght(int runLenght) {
        this.runLenght = runLenght;
    }

    @Override
    public int running() {
        System.out.println(this.name + " is Running");
        return this.runLenght;
    }

    public int jump() {
        System.out.println(this.name + " is Jumping");
        return this.jumpHeight;
    }

    @Override
    public int run() {
        return Jumping.super.run();
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " Im Jumping " + this.jumpHeight +
                " and Running " + this.runLenght;
    }
}
