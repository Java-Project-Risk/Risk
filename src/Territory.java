import java.lang.reflect.Array;
import java.util.ArrayList;

public class Territory extends Region {

    private String name;
    protected int number;
    protected Region region;
    protected Player player = null;
    protected ArrayList<Territory> neighbors = new ArrayList<>();
    //protected ArrayList<Territory> sea_connections = new ArrayList<>();
    protected ArrayList<Unit> units = new ArrayList<>();

    public Territory(String name, int number, Region region) {
        this.name = name;
        this.number = number;
        this.region = region;
    }

    public String getName() {
        return this.name;
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

    /*public ArrayList getSeaConnections() {
        return this.sea_connections;
    }

    public void setSeaConnections(ArrayList<Territory> sea_connections) {
        this.sea_connections = sea_connections;
    }
*/
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Unit> getUnits() {
        return this.units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    /**
     * On peut rendre cette méthode plus dynamique (qui s'adapte si on ajoute des catégories
     * d'unités) mais pour le moment je laisse comme ça
     */
    public void showUnits() {
        int soldiers_nb = 0;
        int horsemen_nb = 0;
        int cannons_nb = 0;
        for (int k = 0; k < this.units.size(); k++) {
            if (this.units.get(k).getCategory().equals("Soldat")) {
                soldiers_nb++;
            } else if (this.units.get(k).getCategory().equals("Cavalier")) {
                horsemen_nb++;
            } else {
                cannons_nb++;
            }
        }
        System.out.println(soldiers_nb + "S/" + horsemen_nb + "H/" + cannons_nb + "C");
    }

    /**
     * Affiche le territoire avec son propriétaire et le nombre d'unités présentes dessus
     */
    public void showTerritory() {
        System.out.print(this.name + " (" + this.player.getName() + ") - ");
        this.showUnits();
    }

    public void addUnit(String unit_category) {
        switch (unit_category) {
            case "Soldat":
                this.units.add(new Soldier());
                break;
            case "Cavalier":
                this.units.add(new Horseman());
                break;
            case "Canon":
                this.units.add(new Cannon());
                break;
        }
    }


}
