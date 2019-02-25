package by.group12.zhylin.task3.generator;

public class IdGenerator {
    private IdGenerator() {
    }

    private static int id = 0;

    public static int generateId() {
        return id++;
    }
}