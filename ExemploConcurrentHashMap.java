import java.util.concurrent.ConcurrentHashMap;

public class ExemploConcurrentHashMap {
    public static void main(String[] args) {
        // Criando um ConcurrentHashMap
        ConcurrentHashMap<String, Integer> mapa = new ConcurrentHashMap<>();

        // Thread 1: Adiciona elementos ao mapa
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                mapa.put("Chave" + i, i);
                System.out.println("Thread 1 adicionou: Chave" + i + " -> " + i);
                try {
                    Thread.sleep(100); // Simula uma pausa
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread 2: Lê e atualiza valores no mapa
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                mapa.computeIfPresent("Chave" + i, (key, value) -> value + 10);
                System.out.println("Thread 2 atualizou: Chave" + i + " -> " + mapa.get("Chave" + i));
                try {
                    Thread.sleep(150); // Simula uma pausa
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Iniciando as threads
        t1.start();
        t2.start();

        // Aguarda as threads terminarem
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o mapa final
        System.out.println("Mapa final: " + mapa);
    }
}
