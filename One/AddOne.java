package One;

import java.util.concurrent.Semaphore;

public class AddOne implements Runnable {
    private Resource resource;
    private Semaphore semaphore;

    public AddOne(Resource resource, Semaphore semaphore) {
        this.resource = resource;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < resource.array.length; i++) {
                resource.array[i]++;
            }
            System.out.println("Array after adding one: " + java.util.Arrays.toString(resource.array));
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}