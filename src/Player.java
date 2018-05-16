public class Player {

    protected String name;
    protected Mission mission;
    protected int units_stock;

    public Player() {

    }

    public Player(String name, int units_stock) {
        this.name = name;
        this.units_stock = units_stock;
    }

    public String getName() {
        return this.name;
    }

    public Mission getMission() {
        return this.mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

}
