package task1;

class Message implements Runnable {
    private int messageCounter = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5100);
                messageCounter++;
                System.out.println("=========================");
                System.out.println("Минуло " + (messageCounter * 5) + " секунд.");
                System.out.println("=========================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}