package Third;

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); 
        Programmer programmer1 = new Programmer(phaser, "Programmer 1");
        Programmer programmer2 = new Programmer(phaser, "Programmer 2");
        
        new Thread(programmer1).start();
        new Thread(programmer2).start();
        
      
            int phase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("Phase " + phase + "is completed");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("Phase " + phase + "is completed");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            phase = phaser.getPhase();
            phaser.arriveAndAwaitAdvance();
            System.out.println("Phase " + phase + "is completed");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        phaser.arriveAndDeregister();
        System.out.println("All phases completed");
    }
}