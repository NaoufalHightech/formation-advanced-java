package jour2.ex5;

public class StockTransaction {
    private final Produit produit;
    private final String transactionType;
    private final int amount;


    public StockTransaction(Produit produit, String transactionType, int amount) {
        this.produit = produit;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
