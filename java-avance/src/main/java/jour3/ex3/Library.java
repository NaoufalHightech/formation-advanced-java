package jour3.ex3;


import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Library {
    private final Map<Long, Book> books;
    private final ReentrantReadWriteLock lock;

    public Library(Map<Long, Book> books) {
        this.books = books;
        lock = new ReentrantReadWriteLock();
    }

    // Ajouter un livre (opération exclusive)
    public void ajouterLivre(Book book) {
        Lock writeLock = lock.writeLock();
        try {
            writeLock.lock();
            books.put(book.getId(), book);
            System.out.println("Le livre ID " + book.getId() + " a été ajouté à la bibliothèque.");
        } finally {
            writeLock.unlock();
        }
    }

    // Lire les informations d'un livre (lecture concurrente)
    public void lireInfoLivre(long bookId) {
        Lock readLock = lock.readLock();
        try {
            readLock.lock();
            Book book = books.get(bookId);
            if (book != null) {
                book.lireInfoLivre();
            } else {
                System.out.println("Le livre ID " + bookId + " n'existe pas dans la bibliothèque.");
            }
        } finally {
            readLock.unlock();
        }
    }

    // Emprunter un livre (opération exclusive)
    public void emprunterLivre(long bookId) {
        Lock writeLock = lock.writeLock();
        try {
            writeLock.lock();
            Book book = books.get(bookId);
            if (book != null) {
                book.emprunter();
            } else {
                System.out.println("Le livre ID " + bookId + " n'existe pas dans la bibliothèque.");
            }
        } finally {
            writeLock.unlock();
        }
    }

    // Retourner un livre (opération exclusive)
    public void retournerLivre(long bookId) {
        Lock writeLock = lock.writeLock();
        try {
            writeLock.lock();
            Book book = books.get(bookId);
            if (book != null) {
                book.retourner();
            } else {
                System.out.println("Le livre ID " + bookId + " n'existe pas dans la bibliothèque.");
            }
        } finally {
            writeLock.unlock();
        }
    }
}
