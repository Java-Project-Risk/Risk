public class Unit implements Comparable<Unit> {

    protected String category;
    protected int cost;
    protected int power_min;
    protected int power_max;
    protected int power;
    protected int atk_priority;
    protected int def_priority;
    protected int mvt_points;
    protected Territory territory;

    public Unit() {

    }

    public Unit(Territory territory) {
        this.territory = territory;
    }

    public String getCategory() {
        return this.category;
    }

    public int getCost() {
        return this.cost;
    }

    public int getPowerMin() {
        return this.power_min;
    }

    public int getPowerMax() {
        return this.power_max;
    }

    public int getAtkPriority() {
        return this.atk_priority;
    }

    public int getDefPriority() {
        return this.def_priority;
    }

    public int getMvtPoints() {
        return this.mvt_points;
    }

    public void setMvtPoints(int mvt_points) {
        this.mvt_points = mvt_points;
    }

    public Territory getTerritory() {
        return this.territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void generatePower() {
        int k = power_max + 1 - power_min;
        int random_number = (int) (Math.random() * k);
        random_number += + this.power_min;
        this.power = random_number;
    }

    public int compareTo(Unit compared_unit) {
        int comparison_criterion = ((Unit)compared_unit).getDefPriority();
        /* For Ascending order*/
        return this.def_priority - comparison_criterion;

        /* For Descending order do like this */
        //return compareage-this.studentage;
    }
}

