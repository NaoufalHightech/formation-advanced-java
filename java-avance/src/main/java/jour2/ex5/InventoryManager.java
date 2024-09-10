package jour2.ex5;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class InventoryManager {
    private final ConcurrentHashMap<Long, Produit> produits = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<StockTransaction> transactions = new CopyOnWriteArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public void addProduit(Produit produit) {
        System.out.println("Debut ajout produit");
        produits.put(produit.getId(), produit);
        System.out.println("Fin ajout produit");
    }

    public Produit getProduct(String produitId) {
        return produits.get(produitId);
    }

    public void addTransaction(StockTransaction transaction) {
        lock.lock();
        try {
            System.out.println("Debut transaction");
            transactions.add(transaction);
            System.out.println("Fin transaction");
        } finally {
            lock.unlock();
        }
    }



}
