package One;

import java.util.concurrent.Semaphore;

public class SubtractTwo implements Runnable {
    private Resource resource;
    private Semaphore semaphore;

    public SubtractTwo(Resource resource, Semaphore semaphore) {
        this.resource = resource;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for (int i = 0; i < resource.array.length; i++) {
                resource.array[i] -= 2;
            }
            System.out.println("Array after subtracting two: " + java.util.Arrays.toString(resource.array));
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
