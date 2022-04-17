package ru.geekbrains.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
        Member[] participants = new Member[6];
        Barriers[] bariers = new Barriers[6];
        participants[0] = new Person("Bob", 150, 150);
        participants[1] = new Cat("Tom", 200, 300);
        participants[2] = new Robot("r2d2", 20, 50);
        participants[3] = new Cat("Mike", 180, 240);
        participants[4] = new Robot("3cpo", 40, 150);
        participants[5] = new Person("Joe", 250, 50);

        bariers[0] =  new Wall("wall1", 100);
        bariers[1] = new Treadmill("Treadmill1", 100);
        bariers[2] = new Treadmill("Treadmill2", 80);
        bariers[3] = new Treadmill("Treadmill3", 65);
        bariers[4] =  new Wall("wall1", 90);
        bariers[5] =  new Wall("wall1", 75);


    }

    private static void jumpTroughWall(Wall wall, Jumping ...jampings) {
        for (Jumping jumping : jampings) {
            System.out.println(jumping);
            System.out.println(wall.areJump(jumping));
            System.out.println("---");
        }
    }
            private static void treadmillRun(Treadmill treadmill, Running ...runnings){
            for (Running running : runnings) {
                System.out.println(running);
                System.out.println(treadmill.areRun(running));
                System.out.println("---");
            }
        }

}
