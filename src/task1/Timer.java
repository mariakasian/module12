package task1;

class Timer implements Runnable {
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;

            System.out.println("Минуло " + elapsedTime / 1000 + "c.");
        }
    }
}