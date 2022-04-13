package ru.geekbrains.lesson1;

public class Robot implements Jumping, Running, Member{
    private String name;
    private int jumpHeight;
    private int runDist;

    public Robot(String name, int jumpHeight, int runDist) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDist = runDist;
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

    public int getRunDist() {
        return runDist;
    }

    public void setRunDist(int runDist) {
        this.runDist = runDist;
    }

    @Override
    public int running() {
        System.out.println(this.name + " is running");
        return this.runDist;
    }

    public int jump() {
        System.out.println("Cat is jumping");
        return this.runDist;
    }

    @Override
    public int run() {
        return Jumping.super.run();
    }

    @Override
    public String toString() {
        return "My name is " + this.name + " Im Jumping " + this.jumpHeight +
                " and Running " + this.runDist;
    }
}
