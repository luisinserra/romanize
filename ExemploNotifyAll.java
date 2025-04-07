public class ExemploNotifyAll {
    public static void main(String[] args) {
        final Object lock = new Object();

        // Thread 1: espera pelo monitor
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

        // Thread 2: espera pelo monitor
        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread 2 esperando...");
                    lock.wait(); // Thread 2 entra em espera
                    System.out.println("Thread 2 acordada!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread notificadora
        Thread notificadora = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread notificadora: acordando todas as threads...");
                lock.notifyAll(); // Acorda todas as threads em espera
            }
        });

        t1.start();
        t2.start();

        // Pequena pausa para garantir que as threads estejam em espera
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        notificadora.start(); // Inicia a thread notificadora
    }
}
