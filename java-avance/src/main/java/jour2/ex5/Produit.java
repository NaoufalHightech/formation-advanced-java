package jour2.ex5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Produit {
    private long id;
    private String nom;
    private int quantite;
    private double prix;
    private final Lock lock;

    public double getPrix() {
        return prix;
    }


    public Produit(long id, String nom, int quantite, double prix) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.lock = new ReentrantLock();
    }

    public void ajoutStock(int amount) {
        lock.lock();
        try {
            this.quantite += amount;
        } finally {
            lock.unlock();
        }
    }

    public boolean retirerStock(int amount) {
        lock.lock();
        try {
            if (amount <= this.quantite) {
                this.quantite -= amount;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }


    public Long getId() {
        return this.id;
    }

}
