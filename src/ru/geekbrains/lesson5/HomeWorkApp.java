package ru.geekbrains.lesson5;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) throws InterruptedException {
        int SIZE = 10_000_000;
        int HALFSIZE = SIZE / 2;
        firstMethod(SIZE);
        secondMethod(SIZE, HALFSIZE);
    }

    public static void arrayCalculation(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }

    public static void firstMethod(int size) {
        System.out.println("Начнаем метод в один поток");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        arrayCalculation(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println("_______________________________");
    }

    public static void secondMethod(int size, int halfSize) throws InterruptedException {
        System.out.println("Начнаем метод с многопоточностью");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        float[] leftHalf = new float[halfSize];
        float[] rightHalf = new float[halfSize];
        System.arraycopy(arr, 0, leftHalf, 0, halfSize);
        System.out.println("leftHalf split time: " + (System.currentTimeMillis() - startTime) + " ms.");
        long firstHalfTime = System.currentTimeMillis();
        System.arraycopy(arr, halfSize, rightHalf, 0, halfSize);
        System.out.println("rightHalf split time: " + (System.currentTimeMillis() - firstHalfTime) + " ms.");
        Thread leftThread = new Thread(() -> {
            long startFirstCalc = System.currentTimeMillis();
            arrayCalculation(leftHalf);
            System.out.println("First Array Calc time: " + (System.currentTimeMillis() - startFirstCalc) + " ms.");
        });
        Thread rightThread = new Thread(() -> {
            long startSecondCalc = System.currentTimeMillis();
            arrayCalculation(rightHalf);
            System.out.println("Second Array Calc time: " + (System.currentTimeMillis() - startSecondCalc) + " ms.");
        });
        leftThread.start();
        rightThread.start();
        leftThread.join();
        rightThread.join();
        long mergeTime = System.currentTimeMillis();
        float[] mergedArr = new float[size];
        System.arraycopy(leftHalf, 0, mergedArr, 0, halfSize);
        System.arraycopy(rightHalf, 0, mergedArr, halfSize, halfSize);
        System.out.println("Merge Time split: " + (System.currentTimeMillis() - mergeTime) + " ms.");
        System.out.println("Program Time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}


