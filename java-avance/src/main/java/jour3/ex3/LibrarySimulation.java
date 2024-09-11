package jour3.ex3;

import jour3.ex3.Library;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LibrarySimulation {

    public static void main(String[] args) {
        // Création de la map pour les livres
        Map<Long, Book> books = new HashMap<>();

        // Création de l'instance de la bibliothèque avec la map de livres
        Library library = new Library(books);

        // Ajout de quelques livres dans la bibliothèque
        books.put(1L, new Book(1));
        books.put(2L, new Book(2));
        books.put(3L, new Book(3));
        books.put(4L, new Book(4));
        books.put(5L, new Book(5));

        // Création d'un pool de threads pour gérer les lecteurs et écrivains
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        Random random = new Random();

        // Création et soumission de 5 tâches de lecteurs en utilisant des lambdas
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 10; j++) { // Chaque lecteur lit 10 fois
                    long bookId = random.nextInt(5) + 1; // Sélectionne un livre aléatoire entre 1 et 5
                    System.out.println(Thread.currentThread().getName());
                    library.lireInfoLivre(bookId);
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(500)); // Pause aléatoire entre 0 et 500 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // Création et soumission de 2 tâches d'écrivains en utilisant des lambdas
        for (int i = 0; i < 2; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 5; j++) { // Chaque écrivain effectue 5 opérations
                    long bookId = random.nextInt(5) + 1; // Sélectionne un livre aléatoire entre 1 et 5
                    System.out.println(Thread.currentThread().getName() + "  " + bookId);
                    library.emprunterLivre(bookId);
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000)); // Pause aléatoire entre 0 et 1000 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "  " + bookId);
                    library.retournerLivre(bookId);
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000)); // Pause aléatoire entre 0 et 1000 ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        // Arrêt du pool de threads après la fin de toutes les tâches
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Simulation terminée.");
    }
}
