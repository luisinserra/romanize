import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExemploReentrantLock {
    private static int contador = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> incrementar());
        Thread t2 = new Thread(() -> incrementar());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Contador final: " + contador);
    }

    private static void incrementar() {
        for (int i = 0; i < 1000; i++) {
            lock.lock(); // Adquire o lock
            try {
                contador++;
            } finally {
                lock.unlock(); // Libera o lock
            }
        }
    }

}
