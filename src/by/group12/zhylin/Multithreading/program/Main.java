package by.group12.zhylin.Multithreading.program;

import by.group12.zhylin.Multithreading.entity.Harbor;
import by.group12.zhylin.Multithreading.entity.Ship;

public class Main {
    public static void main(String[] args) {

        Harbor harbor = Harbor.createHarbor(3);//number of Harbor

        new Thread(new Ship("Silver_Maruun", 5, harbor, 5)).start();
        new Thread(new Ship("Habib_Panara", 5, harbor, 1)).start();
        new Thread(new Ship("Tipps_Merlo", 3, harbor, 3)).start();
        new Thread(new Ship("Winter_Winner", 5, harbor, 5)).start();
        new Thread(new Ship("Orca_of_Taruu", 7, harbor, 4)).start();
        new Thread(new Ship("QueenMary_15", 9, harbor, 2)).start();
    }
}