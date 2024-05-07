package One;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Resource resource = new Resource(5);
        resource.printArray();
        Semaphore semaphore = new Semaphore(1);

        Thread thread1 = new Thread(new AddOne(resource, semaphore));
        Thread thread2 = new Thread(new MultiplyThree(resource, semaphore));
        Thread thread3 = new Thread(new SubtractTwo(resource, semaphore));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}