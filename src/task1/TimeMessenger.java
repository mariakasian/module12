package task1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimeMessenger {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Timer());
        executorService.execute(new Message());

    }
}
