package jour2.ex4;

public class Transaction {

    public enum TypeTransaction {
        DEPOT,
        RETRAIT
    }

    private double montant;
    private TypeTransaction type;

    public Transaction(double montant, TypeTransaction typeTransaction) {
        this.montant = montant;
        this.type = typeTransaction;
    }

    public double getMontant() {
        return montant;
    }

    public TypeTransaction getType() {
        return type;
    }
}
