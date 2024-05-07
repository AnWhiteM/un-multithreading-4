package Two;

import java.util.concurrent.Exchanger;

public class FirstRunnable implements Runnable {
    private final Exchanger<String> exchanger;

    public FirstRunnable(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String message = "Слава Україні!";
            String receivedMessage = exchanger.exchange(message);
            System.out.println("Перший потік отримав повідомлення: " + receivedMessage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
