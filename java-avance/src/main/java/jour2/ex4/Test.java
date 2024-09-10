package jour2.ex4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {

        double solde = 10_000;
        BankAccount bankAccount = new BankAccount(solde);
        TransactionManager transactionManager = new TransactionManager(bankAccount);
        System.out.println("Solde initial du compte " + solde);

        Thread p1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Début depot : " + Thread.currentThread().getName());
                transactionManager.depot(10);
                System.out.println("Fin depot : " + Thread.currentThread().getName());
            }
        });

        Thread p2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Début retrait : " + Thread.currentThread().getName());
                transactionManager.retrait(20);
                System.out.println("Fin retrait : " + Thread.currentThread().getName());

            }
        });

        p1.start();
        p2.start();
        try{
            p1.join();
            p2.join();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        /*

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(5);

            executorService.execute(p1);
            executorService.execute(p2);
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException ex) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }

        }*/
        System.out.println("Fin du programme ! ");
    }
}
