package jour1.ex2;

import java.util.Comparator;
import java.util.concurrent.*;


public class QueueManager {
    /**
     * +-------------------+      +-------------------+      +-------------------+
     * |                   |      |                   |      |                   |
     * |      Client 1      |      |    QueueManager   |      |      Agent 1       |
     * |   (Producer)       |  +-->|  (BlockingQueue)  |<---->|   (Consumer)       |
     * +-------------------+  |   |                   |      +-------------------+
     *                        |   +-------------------+
     * +-------------------+  |                                +-------------------+
     * |                   |  |   +-------------------+        |                   |
     * |      Client 2      |  |   |                   |        |      Agent 2       |
     * |   (Producer)       |  +-->|  (BlockingQueue)  |<----->|   (Consumer)       |
     * +-------------------+      |                   |        +-------------------+
     *                             +-------------------+
     */
    private final BlockingQueue<Client> queue ;

    public QueueManager(){
        this.queue = new PriorityBlockingQueue<>(10, Comparator.comparing(Client::getIdClient));
    }

    public QueueManager(BlockingQueue queue){
        this.queue = queue;
    }
    public void ajouterClient(Client client){
        try {
            queue.put(client);
            System.out.println(client.getIdClient());
            System.out.println("Client " + client.getIdClient() + " est ajouté à la queue.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Client getNextClient(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }

    }

    public boolean hasClient(){
        return !queue.isEmpty();
    }

}


