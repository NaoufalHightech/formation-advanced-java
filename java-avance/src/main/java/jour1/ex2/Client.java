package jour1.ex2;

public class Client {
    private final String name;
    private final int idClient;

    public Client(String name, int idClient) {
        this.name = name;
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public int getIdClient() {
        return idClient;
    }
}
