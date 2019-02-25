package by.group12.zhylin.Multithreading.entity;

import by.group12.zhylin.Multithreading.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ship implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private String name;
    private int amountContainer;
    private int capacity;
    private Queue<Container> shipStorage;
    private Harbor harbor;
    private Berth berth;
    private Lock lock = new ReentrantLock();

    public Ship(String name, int capacity, Harbor harbor, int amountContainer) {
        System.out.println("Create ship " + name);
        this.name = name;
        if (capacity > 0) {
            this.capacity = capacity;
        }
        if (amountContainer >= 0) {
            this.amountContainer = amountContainer;
        }
        this.harbor = harbor;
        this.shipStorage = new ArrayDeque<Container>(capacity);
        generateСargo();
    }

    private void generateСargo() {
        if (amountContainer > 0) {
            for (int i = 0; i < amountContainer; i++) {
                Container container = new Container(i);
                shipStorage.add(container);
            }
        }
    }

    @Override
    public void run() {
        goToHarbor();
        synchronized (berth) {
            if (amountContainer == 0) {
                loadShip();
            } else {
                if (amountContainer < capacity && amountContainer != 0) {
                    unloadShipe();
                    loadShip();
                }
            }
            if (amountContainer == capacity) {
                unloadShipe();
            }
            goAwayFromHarbor();
        }
    }

    private void loadShip() {
        for (int i = 0; i < capacity - amountContainer; i++) {
            Container container = berth.getContainer();
            if (container == null) {
                System.out.println("There are no products in the Port!");
                return;
            }
            if (shipStorage.offer(container)) {
                System.out.println("Ship " + name + " loaded container №" + container.getRegistrationNumber());
            } else {
                System.out.println("Not enought space on the ship!");
                return;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, "InterruptedException", e);
            }
        }
    }

    private void unloadShipe() {
        if (amountContainer == 0) {
            System.out.println("The ship is impty!");
            return;
        }
        for (int i = 0; i < amountContainer; i++) {
            Container container = shipStorage.poll();
            if (berth.setContainer(container)) {
                System.out.println("Ship " + name + " uploaded container №" + container.getRegistrationNumber());
            } else {
                System.out.println("No place in the port warehouse!");
                return;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                LOGGER.log(Level.ERROR, "InterruptedException", e);
            }
        }
        amountContainer = 0;
    }

    private void goToHarbor() {
        try {
            getBerth();
            TimeUnit.MILLISECONDS.sleep(new Random(100).nextInt(1000));
            System.out.println("Ship " + name + " docked at berth №" + berth.getNumber());
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "InterruptedException", e);
        }
    }

    private void goAwayFromHarbor() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random(100).nextInt(500));
            System.out.println("Ship " + name + " set sail from berth №" + berth.getNumber());
        } catch (InterruptedException e) {
            LOGGER.log(Level.ERROR, "InterruptedException", e);
        } finally {
            harbor.returnResource(berth);
            System.out.println("Berth №" + berth.getNumber() + " is free.");
        }
    }

    private void getBerth() throws InterruptedException {
        do {
            try {
                berth = harbor.getBerth();
            } catch (CustomException e) {
                e.printStackTrace();
            }
            if (berth == null) {
                System.out.println("Ship " + name + " is wait!");
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } while (berth == null);
    }
}