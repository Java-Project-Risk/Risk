import java.util.ArrayList;

public class Region {

    protected String name;
    protected int size;
    protected ArrayList<Territory> territories = new ArrayList<>();
    protected Player player = null;

    public Region() {

    }

    public Region(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public ArrayList getTerritories() {
        return this.territories;
    }

    public void setTerritories(ArrayList<Territory> territories) {
        this.territories = territories;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
