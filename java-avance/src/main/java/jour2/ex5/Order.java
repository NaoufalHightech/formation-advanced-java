package jour2.ex5;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Order {
    private final String orderId;
    private final Map<Produit, Integer> produitsByQuantite;
    private final Lock lock;

    public Order(String orderId, Map<Produit, Integer> produits) {
        this.orderId = orderId;
        this.produitsByQuantite = produits;
        lock = new ReentrantLock();
    }

    public double calculateTotal() {
        lock.lock();
        try {
            return produitsByQuantite.entrySet().stream()
                    .mapToDouble(entry -> entry.getKey().getPrix() * entry.getValue())
                    .sum();
        } finally {
            lock.unlock();
        }
    }

    public void updateStock(InventoryManager inventoryManager) {
        lock.lock();
        try {
            produitsByQuantite.forEach((product, quantity) -> {
                product.ajoutStock(quantity);
                inventoryManager.addTransaction(new StockTransaction(product, "REMOVE", quantity));
            });
        } finally {
            lock.unlock();
        }
    }

    // Getters for the attributes
}
