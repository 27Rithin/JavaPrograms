import java.util.LinkedList;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        final PC pc = new PC();

        // Create producer thread
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        producerThread.start();
        consumerThread.start();

        // Wait for both threads to finish
        producerThread.join();
        consumerThread.join();
    }

    public static class PC {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;
        int produceCount = 0;
        int consumeCount = 0;

        // Produce method
        public void produce() throws InterruptedException {
            int value = 0;
            while (produceCount < 4) { // Limit to 4 productions in total
                synchronized (this) {
                    // Wait if the buffer is full
                    while (list.size() == capacity) {
                        wait();
                    }

                    // Produce item
                    System.out.println("Producer produced: " + value);
                    list.add(value++);
                    produceCount++;

                    // Notify the consumer to consume
                    notify();

                    // Give the consumer a chance to consume the items
                    Thread.sleep(500);
                }
            }
        }

        // Consume method
        public void consume() throws InterruptedException {
            while (consumeCount < 4) { // Limit to 4 consumptions in total
                synchronized (this) {
                    // Wait if the buffer is empty
                    while (list.size() == 0) {
                        wait();
                    }

                    // Consume item
                    int val = list.removeFirst();
                    System.out.println("Consumer consumed: " + val);
                    consumeCount++;

                    // Notify the producer to produce
                    notify();

                    // Give the producer a chance to produce the items
                    Thread.sleep(500);
                }
            }
        }
    }
}