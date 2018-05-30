import java.util.ArrayList;
import java.util.Arrays;
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
     * Demande au joueur combien d'unités de chaque catégorie il veut ajouter à chaque territoire en sa possession
     * Cette fonction sera utile au début de la partie lors du positionnement des unités
     * et au début de chaque tour, après la réception des renforts
     * <p>
     * Pistes d'amélioration :
     * - là on passe la liste de tous les territoires en paramètres et on regarde à chaque fois si le territoire appartient
     * ou non au joueur avant de lui demander ce qu'il veut y mettre. Mais on pourrait peut-être mettre la liste des territoires
     * appartenant au joueur directement en attribut de classe
     * - la fonction n'est pas dynamique : si on veut rajouter une nouvelle unité au jeu ou changer de nom, il faut venir
     * faire des modifications ici, c'est pas top
     *
     * @param regions Liste des régions (et donc des territoires)
     */
    public void repartUnitsInitialisation(ArrayList<Region> regions) {
        for (int i = 0; i < regions.size(); i++) {
            Region region = regions.get(i);
            for (int j = 0; j < region.getTerritories().size(); j++) {
                Territory territory = region.getTerritories().get(j);
                // Pour chaque territoire appartenant au joueur, on positionne 1 soldat
                if (territory.getPlayer().getName().equals(this.name)) {
                    territory.addUnit("Soldat");
                    this.units_stock = this.units_stock - 1;
                }
            }
        }
        System.out.println();
    }

    public void repartUnitsfirsttour(ArrayList<Region> regions) {
        System.out.println("Répartition " + this.name + " - NOSECU : ");
        for (int i = 0; i < regions.size(); i++) {
            while (this.units_stock > 0) {
                Region region = regions.get(i);
                System.out.println(region.getName());
                for (int j = 0; j < region.getTerritories().size(); j++) {
                    boolean circle = true;
                    Territory territory = region.getTerritories().get(j);
                    //while (circle) {
                    // Pour chaque territoire appartenant au joueur, on lui demande combien de soldat il veut mettre
                    if (territory.getPlayer().getName().equals(this.name) && this.units_stock > 0) {
                        System.out.println("Points d'unité : " + this.units_stock);
                        System.out.println("    - " + territory.getName() + " : ");
                        System.out.print("        - Soldat(s) : ");
                        int soldiers_nb = scan.nextInt();
                        if (this.units_stock - soldiers_nb >= 0) {
                            // Création des unités
                            for (int k = 0; k < soldiers_nb; k++) {
                                territory.addUnit("Soldat");
                            }
                            this.units_stock = this.units_stock - soldiers_nb;
                            circle = false;
                        } else {
                            System.out.println("Pas assez de points");
                        }
                    }

                    //}
                }
            }
        }
        System.out.println();
    }


    public void repartUnits(ArrayList<Region> regions) { /// TODO des choses à revoir pour cette fonction
        // vérifier qu'on peut bien rajouter soldat cavalier et canon

        int soldiers_nb = 0;
        int horsemen_nb = 0;
        int cannons_nb = 0;

        System.out.println("Répartition " + this.name + " - NOSECU : ");
        for (int i = 0; i < regions.size(); i++) {
            while (this.units_stock > 0) {
                Region region = regions.get(i);
                System.out.println(region.getName());
                for (int j = 0; j < region.getTerritories().size(); j++) {
                    Territory territory = region.getTerritories().get(j);

                    // Pour chaque territoire appartenant au joueur, on lui demande combien d'unités de chaque catégorie il veut mettre
                    if (territory.getPlayer().getName().equals(this.name) && this.units_stock >= 0) {
                        System.out.println("Points d'unité : " + this.units_stock);
                        System.out.println("    - " + territory.getName() + " : ");
                        System.out.print("        - Canon(s) : ");
                        cannons_nb = scan.nextInt();
                        if ((this.units_stock - cannons_nb * 7) >= 0) {
                            System.out.println("Points d'unité : " + (this.units_stock-cannons_nb*7));
                            System.out.print("        - Cavalier(s) : ");
                            horsemen_nb = scan.nextInt();
                            if ((this.units_stock - (cannons_nb * 7 + horsemen_nb * 3)) >= 0) {
                                System.out.println("Points d'unité : " + (this.units_stock-cannons_nb*7-horsemen_nb*3));
                                System.out.print("        - Soldat(s) : ");
                                soldiers_nb = scan.nextInt();
                            } else {
                                System.out.println("Pas assez de points");
                            }
                        } else {
                            System.out.println("Pas assez de points");
                        }

                        // Création des unités
                        for (int k = 0; k < soldiers_nb; k++) {
                            territory.addUnit("Soldat");
                        }
                        for (int k = 0; k < horsemen_nb; k++) {
                            territory.addUnit("Cavalier");
                        }
                        for (int k = 0; k < cannons_nb; k++) {
                            territory.addUnit("Canon");
                        }

                        this.units_stock = this.units_stock - (soldiers_nb + horsemen_nb * 3 + cannons_nb * 7);
                    } else{
                        System.out.println("on est là");
                    }

                }
            }
        }
        System.out.println();
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
        System.out.println();
        System.out.println("Lancer de dés...");

        for (int k = 0; k < attacking_units.size(); k++) {
            attacking_units.get(k).generatePower();
        }
        for (int k = 0; k < defending_units.size(); k++) {
            defending_units.get(k).generatePower();
        }

        /*
        // Test pour une configuration particulière (commenter ce qu'il y a au dessus)
        ArrayList<Unit> attacking_units = new ArrayList<>(Arrays.asList(
                new Soldier()));
        ArrayList<Unit> defending_units = new ArrayList<>(Arrays.asList(
                new Soldier()));

        attacking_units.get(0).setPower(3);
        defending_units.get(0).setPower(3);
        */

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

        // On lance les duels
        System.out.println();
        int win_counter = defending_units.size();
        int round = 1;
        while ((attacking_units.size() != 0) && (defending_units.size() != 0)) {
            System.out.println("Duel " + round + " : ");
            Unit atk_unit = findBestAtkUnit(attacking_units);
            Unit def_unit = findBestDefUnit(defending_units);
            System.out.println("    - " + atk_unit.getCategory() + " : " + atk_unit.getPower());
            System.out.println("    - " + def_unit.getCategory() + " : " + def_unit.getPower());
            if (atk_unit.getPower() > def_unit.getPower()) {
                defending_territory.getUnits().remove(def_unit);
                win_counter--;
                System.out.println("-> " + atk_unit.getCategory() + " vainqueur");
            } else {
                attacking_territory.getUnits().remove(atk_unit);
                System.out.println("-> " + def_unit.getCategory() + " vainqueur");
            }
            System.out.println();
            round++;
        }

        if (win_counter == 0) {
            System.out.println("Attaquant vainqueur");
        } else {
            System.out.println("Défenseur vainqueur");
        }

    }

    private Unit findBestAtkUnit(ArrayList<Unit> units) {
        Unit best_unit = units.get(0);
        int k = 1;

        while (k < units.size()) {
            Unit unit = units.get(k);
            if (unit.getPower() > best_unit.getPower()) {
                best_unit = unit;
            } else if (unit.getPower() == best_unit.getPower()) {
                if (unit.getAtkPriority() > best_unit.getAtkPriority()) {
                    best_unit = unit;
                }
            }
            k++;
        }

        units.remove(best_unit);
        return best_unit;
    }

    private Unit findBestDefUnit(ArrayList<Unit> units) {
        Unit best_unit = units.get(0);
        int k = 1;

        while (k < units.size()) {
            Unit unit = units.get(k);
            if (unit.getPower() > best_unit.getPower()) {
                best_unit = unit;
            }
            k++;
        }

        units.remove(best_unit);
        return best_unit;
    }

    public int territoryPlayerCounter(ArrayList<Region> regions) {
        int counter = 0;
        for (int counterRegion = 0; counterRegion < regions.size(); counterRegion++) {
            for (int counterTerritory = 0; counterTerritory < regions.get(counterRegion).getTerritories().size(); counterTerritory++) {
                if (regions.get(counterRegion).getTerritories().get(counterTerritory).getPlayer().getName().equals(this.getName())) {
                    counter++;
                }
            }
        }
        System.out.println("Le joueur " + this.getName() + " possède " + counter + " territoires sur toute la carte");
        return counter;
    }

    public int regionPlayerCounter(ArrayList<Region> regions){
        int regionPlayerCounter = 0;
        for (int regionCounter = 0; regionCounter < regions.size(); regionCounter++) {
            int counter = 0;
            for (int territoryCounter = 0; territoryCounter < regions.get(regionCounter).getTerritories().size(); territoryCounter++) {
                if (regions.get(regionCounter).getTerritories().get(territoryCounter).getPlayer().getName().equals(this.name)) {
                    counter++;
                }
            }
            if (counter == regions.get(regionCounter).getTerritories().size()) {
                regionPlayerCounter++;
            }
        }
        return regionPlayerCounter;
    }

    public void setUnits_stock(int units_stock) {
        this.units_stock = units_stock;
    }
}
