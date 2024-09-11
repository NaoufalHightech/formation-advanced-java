package jour3.ex2;

import java.util.List;

public class Test {

    record Product(String name, double price) {

        // Calculer le prix total d'une liste de produits
        public static double calculateTotalPrice(List<jour3.ex2.Test.Product> products) {
            return products.stream()
                    .mapToDouble(jour3.ex2.Test.Product::price)
                    .sum();
        }

       public static String categorizeProduct(jour3.ex2.Test.Product product) {
            return switch (product.name()) {
                case "PC", "Smartphone" -> "Électronique";
                case "Pain", "Lait" -> "Épicerie";
                case "Shirt", "Jeans" -> "Vêtements";
                default -> "Divers";
            };
        }
    }

    class ProductService {

        // Afficher les détails de la commande
        public static void printOrderDetails(Object order) {
            if (order instanceof List<?> productList && productList.stream().allMatch(Product.class::isInstance)) {
                List<jour3.ex2.Test.Product> products = (List<Product>) productList;
                products.forEach(product ->
                        System.out.println("Nom du produit : " + product.name() + ", Prix : " + product.price())
                );
                System.out.println("Prix total : " + Product.calculateTotalPrice(products));
            } else {
                System.out.println("Commande invalide.");
            }
        }
    }
    public static void main(String[] args) {
        List<jour3.ex2.Test.Product> order = List.of(
                new jour3.ex2.Test.Product("PC", 999.99),
                new jour3.ex2.Test.Product("Pain", 2.50),
                new jour3.ex2.Test.Product("Shirt", 29.99)
        );

        ProductService.printOrderDetails(order);

        // Test de la méthode categorizeProduct
        jour3.ex2.Test.Product product = new jour3.ex2.Test.Product("PC", 999.99);
        System.out.println("Category: " + Product.categorizeProduct(product));
    }
}
