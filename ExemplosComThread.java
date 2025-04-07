public class ExemplosComThread {
    
        public static void main(String[] args) {
            final Object lock = new Object();
    
            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    try {
                        System.out.println("Thread 1 esperando...");
                        lock.wait(); // Thread 1 entra em espera
                        System.out.println("Thread 1 acordada!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    
            Thread t2 = new Thread(() -> {
                synchronized (lock) {
                    System.out.println("Thread 2 notificando...");
                    lock.notify(); // Acorda a Thread 1
                }
            });
    
            t1.start();
            t2.start();
        }
    }

