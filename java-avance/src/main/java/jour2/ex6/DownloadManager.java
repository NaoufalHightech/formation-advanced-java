package jour2.ex6;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloadManager {

    public static void main(String[] args) {
        downloadAsyncWithPause("url du fichier").thenRun(() ->
                System.out.println("Téléchargement terminé avec succès.")
        );
    }

    public static CompletableFuture<Void> downloadAsync(String url) {
        return CompletableFuture.runAsync(() -> {

            System.out.println("Téléchargement en cours du fichier : " + url);

        });

    }

    public static CompletableFuture<Void> downloadAsyncWithPause(String url) {
        return CompletableFuture.runAsync(() -> {
            System.out.println("Téléchargement en cours du fichier : " + url);
            try {
                // Simuler un téléchargement avec une pause aléatoire entre 1 et 5 secondes
                int delay = new Random().nextInt(5) + 1;
                TimeUnit.SECONDS.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Erreur lors de la simulation du téléchargement", e);
            }
        });
    }
}
