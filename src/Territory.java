import java.util.ArrayList;

public class Territory extends Region {

    private String name;
    protected int number;
    protected Region region;
    protected Player player = null;
    protected ArrayList<Territory> neighbors = new ArrayList<>();
    protected ArrayList<Territory> sea_connections = new ArrayList<>();

    public Territory(String name, int number, Region region) {
        this.name = name;
        this.number = number;
        this.region = region;
    }

    public int getNumber() {
        return this.number;
    }

    public ArrayList getNeighbors() {
        return this.neighbors;
    }

    public void setNeighbors(ArrayList<Territory> neighbors) {
        this.neighbors = neighbors;
    }

    public ArrayList getSeaConnections() {
        return this.sea_connections;
    }

    public void setSeaConnections(ArrayList<Territory> sea_connections) {
        this.sea_connections = sea_connections;
    }

}
