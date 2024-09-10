package jour2.ex5;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Add products to the inventory
        Produit product1 = new Produit(1, "Product A", 100, 10.0);
        Produit product2 = new Produit(2, "Product B", 200, 20.0);
        inventoryManager.addProduit(product1);
        inventoryManager.addProduit(product2);


        Runnable worker = () -> {
            // Simulate order creation and stock updates
            Map<Produit, Integer> produitsByQuantite = new HashMap<>();
            produitsByQuantite.put(product1, 10);
            produitsByQuantite.put(product2, 20);
            Order order = new Order("Order1", produitsByQuantite);
            order.updateStock(inventoryManager);
            System.out.println("Total : "+ order.calculateTotal());
        };

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
