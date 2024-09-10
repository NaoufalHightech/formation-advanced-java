package jour2.ex4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionManager {

    // Le compte bancaire à gérer
    BankAccount bankAccount;
    private final Lock lock = new ReentrantLock();

    public TransactionManager(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void depot(double montant) {
        try {
            //lock.lock();
            bankAccount.depot(montant);
        } finally {
            //lock.unlock();
        }

    }

    public void retrait(double montant) {
        try {
            //lock.lock();
            bankAccount.retrait(montant);
        } finally {
            //lock.unlock();
        }
    }

}
