import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {

    static Scanner scan = new Scanner(System.in);

    protected String name;
    protected int units_stock;
    protected Mission mission;

    public Player() {

    }

    public Player(String name, int units_stock) {
        this.name = name;
        this.units_stock = units_stock;
    }

    public String getName() {
        return this.name;
    }

    public int getUnitsStock() {
        return this.units_stock;
    }

    public Mission getMission() {
        return this.mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    /**
     * Permet au joueur de choisir avec quelles unités il attaque
     *
     * @param territory Territory
     */
    private ArrayList<Unit> selectAttackingUnits(Territory territory) {
        System.out.println("Sélection des unités attaquantes - NOSECU : ");
        System.out.println("Unités disponibles sur le territoire " + territory.getName() + " : ");
        territory.showUnits();
        System.out.print("Nombre de soldats : ");
        int soldiers_nb = scan.nextInt();
        System.out.print("Nombre de cavaliers : ");
        int horsemen_nb = scan.nextInt();
        System.out.print("Nombre de canons : ");
        int cannons_nb = scan.nextInt();

        ArrayList<Unit> attacking_units = new ArrayList<>();

        for (int k = 0; k < territory.getUnits().size(); k++) {

            String unit_category = territory.getUnits().get(k).getCategory();

            if (unit_category.equals("Soldat") && (soldiers_nb != 0)) {
                attacking_units.add(territory.getUnits().get(k));
                soldiers_nb--;
            } else if (unit_category.equals("Cavalier") && (horsemen_nb != 0)) {
                attacking_units.add(territory.getUnits().get(k));
                horsemen_nb--;
            } else if (unit_category.equals("Canon") && (cannons_nb != 0)) {
                attacking_units.add(territory.getUnits().get(k));
                cannons_nb--;
            }

        }

        System.out.println();
        System.out.println("Unités sélectionnées pour l'attaque : ");
        for (int k = 0; k < attacking_units.size(); k++) {
            System.out.println("    - " + attacking_units.get(k).getCategory());
        }

        return attacking_units;
    }

    private ArrayList<Unit> selectDefendingUnits(Territory territory) {
        ArrayList<Unit> defending_units = new ArrayList<>();

        Collections.sort(territory.getUnits());

        int max_defenders_nb = 2;
        int k = 0;
        while ((k < territory.getUnits().size()) && (defending_units.size() < max_defenders_nb)) {
            defending_units.add(territory.getUnits().get(k));
            k++;
        }

        System.out.println();
        System.out.println("Unités sélectionnées pour la défense : ");
        for (k = 0; k < defending_units.size(); k++) {
            System.out.println("    - " + defending_units.get(k).getCategory());
        }

        return defending_units;
    }

    /**
     * Permet au joueur d'attaquer un territoire (defending_territory)
     * avec un de ses territoires (attacking_territory)
     *
     * @param attacking_territory Territory
     * @param defending_territory Territory
     */
    public void launchAttack(Territory attacking_territory, Territory defending_territory) {

        // On sélectionne les unités à faire combattre
        ArrayList<Unit> attacking_units = this.selectAttackingUnits(attacking_territory);
        ArrayList<Unit> defending_units = this.selectDefendingUnits(defending_territory);

        // On génère une puissance pour chaque unité
        for (int k = 0; k < attacking_units.size(); k++) {
            attacking_units.get(k).generatePower();
        }
        for (int k = 0; k < defending_units.size(); k++) {
            defending_units.get(k).generatePower();
        }

        System.out.println();
        System.out.println("Lancer de dés...");
        System.out.println();
        System.out.println("Attaquants : ");
        for (int k = 0; k < attacking_units.size(); k++) {
            System.out.println("    - " + attacking_units.get(k).getCategory() + " -> power : " + attacking_units.get(k).getPower());
        }
        System.out.println();
        System.out.println("Défenseurs : ");
        for (int k = 0; k < defending_units.size(); k++) {
            System.out.println("    - " + defending_units.get(k).getCategory() + " -> power : " + defending_units.get(k).getPower());
        }
    }

}
