public class ExemploJoinThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread 1 iniciada.");
                Thread.sleep(2000); // Simula trabalho
                System.out.println("Thread 1 finalizada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("Thread 2 iniciada.");
                Thread.sleep(1000); // Simula trabalho
                System.out.println("Thread 2 finalizada.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        try {
            // Aguarda a conclusão das threads
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Execução principal finalizada.");
    }
}
