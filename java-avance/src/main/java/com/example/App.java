package com.example;

import jour1.ex2.Client;
import jour1.ex2.ServiceDesk;
import jour2.ex3.Ex3;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

 /*       System.out.println("Ex2");

        ServiceDesk serviceDesk = new ServiceDesk(2);
        Client toto1 = new Client("toto1", 1);
        Client toto2 = new Client("toto2", 2);
        Client toto3 = new Client("toto3", 3);
        serviceDesk.addClientToQueue(toto1);
        serviceDesk.addClientToQueue(toto2);
        serviceDesk.addClientToQueue(toto3);

        serviceDesk.startService();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        serviceDesk.closeService();
        System.out.println(Thread.currentThread().getName());
*/
        System.out.println("Ex3");
        Ex3 ex3 = new Ex3();
        Thread t1 = new Thread(() -> ex3.methode());
        Thread t2 = new Thread(() -> ex3.methode());

        // Démarrage des threads.
        t1.start();
        t2.start();

        // Attendre que les threads se terminent (optionnel mais recommandé).
        try {
            t1.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
