package One;

import java.util.Arrays;
import java.util.Random;

public class Resource {
    public int[] array;

    public Resource(int size) {
        array = new int[size];
        
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10); 
    }
}

     public void printArray() {
        System.out.println("Initial array: " + Arrays.toString(array));
    }
}
