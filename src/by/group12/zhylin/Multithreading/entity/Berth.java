package by.group12.zhylin.Multithreading.entity;

import java.util.Random;
import java.util.Queue;
import java.util.PriorityQueue;

public class Berth {

    private static final int DEFAULT_BERTH_CAPACITY = 50;
    private Queue<Container> containers;
    private int berthNumber;

    public Berth(int number) {
        System.out.println("Create berth");
        berthNumber = number;
        containers = new PriorityQueue<Container>(DEFAULT_BERTH_CAPACITY);
        Random generator = new Random();                             //utochnit!!!!!!!!!!!
        int length = generator.nextInt(30);
        for (int i = 0; i < length; i++) {
            containers.offer(new Container(generator.nextInt(500)));
        }
    }

    public Container getContainer() {
        if (!containers.isEmpty()) {
            return containers.poll();
        } else
            return null;
    }

    public boolean setContainer(Container container) {
        return containers.offer(container);
    }

    public int getNumber() {
        return berthNumber;
    }
}