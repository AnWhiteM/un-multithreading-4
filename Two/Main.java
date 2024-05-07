package Two;

import java.util.concurrent.Exchanger;

public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Thread thread1 = new Thread(new FirstRunnable(exchanger));
        Thread thread2 = new Thread(new SecondRunnable(exchanger));
        thread1.start();
        thread2.start();
    }
}
