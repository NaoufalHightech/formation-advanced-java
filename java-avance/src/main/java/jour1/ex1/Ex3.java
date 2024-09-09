package jour1.ex1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Ex3 {

    public static void main(String[] args) {

        // Création d'un pool de threads avec 10 threads
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Tâche à exécuter par les threads
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            String executionTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println("Thread " + threadName + " executed at " + executionTime);
        };

        // Soumission de 10 tâches au pool de threads
        for (int i = 0; i < 10; i++) {
            executorService.execute(task);
        }

        // Arrêt du pool de threads
        executorService.shutdown();
        try {
            // Attente que toutes les tâches soient terminées
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
