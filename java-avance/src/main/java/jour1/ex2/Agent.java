package jour1.ex2;

public class Agent {
    private int idAgent;
    private String name;
    public Agent(int idAgent, String name) {
        this.idAgent = idAgent;
        this.name = name;
    }

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
