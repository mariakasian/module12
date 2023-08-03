package task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberProcessorTest {
    public static void main(String[] args) {
        NumberProcessor fizz = new NumberProcessor((n) -> {
            if (n % 3 == 0 && n % 5 != 0) {
                System.out.println("fizz");
            }
        });

        NumberProcessor buzz = new NumberProcessor((n) -> {
            if (n % 5 == 0 && n % 3 != 0) {
                System.out.println("buzz");
            }
        });

        NumberProcessor fizzbuzz = new NumberProcessor((n) -> {
            if (n % 5 == 0 && n % 3 == 0) {
                System.out.println("fizzbuzz");
            }
        });

        NumberProcessor number = new NumberProcessor((n) -> {
            if (n % 5 != 0 && n % 3 != 0) {
                System.out.println(n);
            }
        });

        ExecutorService es = Executors.newFixedThreadPool(4);
        es.execute(fizz);
        es.execute(buzz);
        es.execute(fizzbuzz);
        es.execute(number);

        for (int i = 1; i < 16; i++) {
            fizz.process(i);
            buzz.process(i);
            fizzbuzz.process(i);
            number.process(i);

            while (true) {
                int processed = 0;
                if (fizz.isNProcessed()) processed++;
                if (buzz.isNProcessed()) processed++;
                if (fizzbuzz.isNProcessed()) processed++;
                if (number.isNProcessed()) processed++;
                if (processed == 4) {
                    break;
                }
            }
        }
        es.shutdown();
        System.exit(0);
    }
}