package Two;

import java.util.concurrent.Exchanger;

public class SecondRunnable implements Runnable {
    private final Exchanger<String> exchanger;

    public SecondRunnable(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String message = "Героям Слава!";
            String receivedMessage = exchanger.exchange(message);
            System.out.println("Другий потік отримав повідомлення: " + receivedMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}