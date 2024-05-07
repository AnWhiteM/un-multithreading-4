package Third;
import java.util.concurrent.Phaser;

public class Programmer implements Runnable {
    private final Phaser phaser;
    private final String name;
    
    public Programmer(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
        phaser.register(); 
    }
    
    @Override
    public void run() {
        System.out.println(name + " starts gathering business requirements");
        phaser.arriveAndAwaitAdvance(); 

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " starts developing software");
        phaser.arriveAndAwaitAdvance(); 

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " starts testing the created software");
        phaser.arriveAndDeregister();
    }
}