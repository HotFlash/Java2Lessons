package ru.geekbrains.lesson1;

public class Wall implements Barriers{
    private final String name;
    private final int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public boolean areJump(Jumping ableToJump) {
        int jumpingHeight = ableToJump.jump();
        return jumpingHeight >= height;
    }
}
