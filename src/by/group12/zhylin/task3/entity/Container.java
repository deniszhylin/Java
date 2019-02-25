package by.group12.zhylin.task3.entity;

import by.group12.zhylin.task3.generator.IdGenerator;

public class Container implements Comparable{
    private int registrationNumber;
    private int item;

    public Container(int i) {
        item = i;
        registrationNumber = IdGenerator.generateId();
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public int compareTo(Object o) {
               return 0;
    }
}