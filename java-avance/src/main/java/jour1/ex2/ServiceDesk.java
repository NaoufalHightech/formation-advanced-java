package jour1.ex2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServiceDesk {
    QueueManager queueManager;
    ExecutorService executorService;

    public ServiceDesk(int nbAgent) {
        this.queueManager = new QueueManager();
        this.executorService = Executors.newFixedThreadPool(nbAgent);
    }

    // Ajout des clients à la queue
    public void addClientToQueue(Client client) {
        queueManager.ajouterClient(client);
        System.out.println("Utilisateur ajouté" + client.getIdClient());
    }

    public void closeService() {
        executorService.shutdown();
    }

    public void serveClient(Client client) {

        try {
            System.out.println("Client en cours de service " + client.getIdClient());
            Thread.sleep(2000); // Task to do DB or Remote Network call!
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Client servie" + client.getIdClient());
    }

    public void startService() {

        do {
            final Client nextClient = queueManager.getNextClient();
            try {
                Thread.sleep(2000); // Task to do DB or Remote Network call!
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (nextClient != null) {
                executorService.execute(() -> serveClient(nextClient));
            }
        } while (queueManager.hasClient());
    }


}
