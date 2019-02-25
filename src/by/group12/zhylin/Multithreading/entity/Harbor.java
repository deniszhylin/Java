package by.group12.zhylin.Multithreading.entity;

import by.group12.zhylin.Multithreading.exception.CustomException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Harbor {
    private static final int BERTH_NUMBER = 2;
    private final Semaphore semaphore = new Semaphore(BERTH_NUMBER, true);
    private Queue<Berth> berthList = new LinkedList();
    private Lock lock = new ReentrantLock();

    private Harbor() {
        System.out.println("Create Harbor");
    }

    public static Harbor createHarbor(int numberBerth) {
        Harbor harbor = new Harbor();
        for (int i = 0; i < numberBerth; i++) {
            harbor.berthList.add(new Berth(i));
        }
        return harbor;
    }

    public void returnResource(Berth berth) {
        berthList.add(berth);
        semaphore.release();
    }

    public Berth getBerth() throws CustomException {
        lock.lock();
        while (true) {
            try {
                if (semaphore.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                    Berth berth = berthList.poll();
                    if (berth != null) {
                        System.out.println("Berth №" + berth.getNumber() + " reserved.");
                    }
                    lock.unlock();
                    return berth;
                }
            } catch (InterruptedException e) {
                throw new CustomException(":timeout exceeded");
            }
        }
    }
}