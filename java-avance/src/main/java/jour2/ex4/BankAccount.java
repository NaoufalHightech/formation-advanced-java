package jour2.ex4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class BankAccount {

    private double solde;
    private List<Transaction> historiqueTransaction;

    public BankAccount(double solde) {
        this.solde = solde;
        this.historiqueTransaction = new ArrayList<>();
    }

    public double getSolde() {
        return solde;

    }

    public void depot(double montant){
        if (montant > 0 ) {
            solde += montant;
            historiqueTransaction.add( new Transaction(montant, Transaction.TypeTransaction.DEPOT));
            System.out.println("Déposé: " + montant + " | Nouveau solde: " + solde);
        } else {
            System.out.println("Le montant du dépôt doit être supérieur à zéro.");
        }

    }

    public void retrait(double montant){
        if(montant > 0 && montant <= solde) {
            solde -= montant;
            historiqueTransaction.add( new Transaction(montant, Transaction.TypeTransaction.RETRAIT));
            System.out.println("Retiré: " + montant + " | Nouveau solde: " + solde);
        } else if (montant > solde){
            System.out.println("Solde insuffisants pour effectuer un retrait");
        } else {
            System.out.println("Le montant de retrait doit être suprèrieux à zéro !");
        }

    }
}
