import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Board {

    static Scanner scan = new Scanner(System.in);

    private ArrayList<Region> regions = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Mission> missions = new ArrayList<>();

    public Board() {
        this.regionsInitialization();
        this.missionsInitialization();
    }

    /**
     * Initialise la carte :
     * - crétion de toutes les régions
     * - création de tous les territoires
     */
    private void regionsInitialization() {

        // Création de toutes les régions
        Region north_america = new Region("Amérique du Nord", 9);
        Region south_america = new Region("Amérique du Sud", 4);
        Region europe = new Region("Europe", 7);
        Region africa = new Region("Afrique", 6);
        Region asia = new Region("Asie", 12);
        Region oceania = new Region("Océanie", 4);

        /*
        Création de tous les territoires
        Pour chaque territoire, on crée :
            - une liste des territoires voisins
            - une liste des connexions maritimes
         */
        Territory alaska = new Territory("Alaska", 1, north_america);
        Territory west_canada = new Territory("Canada Ouest", 2, north_america);
        Territory mexico = new Territory("Mexico", 3, north_america);
        Territory east_usa = new Territory("Etats-Unis Est", 4, north_america);
        Territory greenland = new Territory("Groenland", 5, north_america);
        Territory north_canada = new Territory("Canada Nord", 6, north_america);
        Territory center_canada = new Territory("Canada Centre", 7, north_america);
        Territory east_canada = new Territory("Canada Est", 8, north_america);
        Territory west_usa = new Territory("Etats-Unis Ouest", 9, north_america);

        Territory argentina = new Territory("Argentine", 1, south_america);
        Territory brazil = new Territory("Brésil", 2, south_america);
        Territory west_latina = new Territory("Amérique latine Ouest", 3, south_america);
        Territory north_latina = new Territory("Amérique latine Nord", 4, south_america);

        Territory great_britain = new Territory("Grande-Bretagne", 1, europe);
        Territory iceland = new Territory("Islande", 2, europe);
        Territory germany = new Territory("Allemagne", 3, europe);
        Territory scandinavia = new Territory("Pays Scandinaves", 4, europe);
        Territory italy = new Territory("Italie", 5, europe);
        Territory east_europe = new Territory("Europe Est", 6, europe);
        Territory france_spain = new Territory("France / Espagne", 7, europe);

        Territory center_africa = new Territory("Afrique Centre", 1, africa);
        Territory east_africa = new Territory("Afrique Est", 2, africa);
        Territory north_africa = new Territory("Egypte / Libye", 3, africa);
        Territory madagascar = new Territory("Madagascar", 4, africa);
        Territory west_africa = new Territory("Afrique Ouest", 5, africa);
        Territory south_africa = new Territory("Afrique Sud", 6, africa);

        Territory center_asia = new Territory("Asie Centre", 1, asia);
        Territory china = new Territory("Chine", 2, asia);
        Territory india = new Territory("Inde", 3, asia);
        Territory south_russia = new Territory("Russie", 4, asia);
        Territory japan = new Territory("Japon", 5, asia);
        Territory east_russia = new Territory("Russie Est", 6, asia);
        Territory middle_east = new Territory("Moyen-Orient", 7, asia);
        Territory mongolia = new Territory("Mongolie", 8, asia);
        Territory thailand = new Territory("Thailande", 9, asia);
        Territory center_russia = new Territory("Russie Centre", 10, asia);
        Territory west_russia = new Territory("Russie Ouest", 11, asia);
        Territory north_russia = new Territory("Russie Nord", 12, asia);

        Territory east_australia = new Territory("Australie Est", 1, oceania);
        Territory polynesia = new Territory("Polynésie", 2, oceania);
        Territory new_zealand = new Territory("Nouvelle-Zélande", 3, oceania);
        Territory west_australia = new Territory("Australie Ouest", 4, oceania);

        // Ajout des listes des territoires voisins et des connexions maritimes aux territoires
        alaska.setNeighbors(new ArrayList<>(Arrays.asList(west_canada, north_canada, east_russia)));
        //alaska.setSeaConnections(new ArrayList<>(Arrays.asList(east_russia)));

        west_canada.setNeighbors(new ArrayList<>(Arrays.asList(alaska, north_canada, center_canada, west_usa)));
        //west_canada.setSeaConnections(new ArrayList<>(Arrays.asList()));

        mexico.setNeighbors(new ArrayList<>(Arrays.asList(east_usa, west_usa, north_latina)));
        //mexico.setSeaConnections(new ArrayList<>(Arrays.asList()));

        east_usa.setNeighbors(new ArrayList<>(Arrays.asList(west_usa, mexico, center_canada, east_canada)));
        //east_usa.setSeaConnections(new ArrayList<>(Arrays.asList()));

        greenland.setNeighbors(new ArrayList<>(Arrays.asList(north_canada, center_canada, east_canada, iceland)));
        //greenland.setSeaConnections(new ArrayList<>(Arrays.asList(north_canada, center_canada, east_canada, iceland)));

        north_canada.setNeighbors(new ArrayList<>(Arrays.asList(alaska, west_canada, center_canada, east_canada, greenland)));
        //north_canada.setSeaConnections(new ArrayList<>(Arrays.asList(greenland)));

        center_canada.setNeighbors(new ArrayList<>(Arrays.asList(west_canada, north_canada, east_canada, west_usa, east_usa, greenland)));
        //center_canada.setSeaConnections(new ArrayList<>(Arrays.asList(greenland)));

        east_canada.setNeighbors(new ArrayList<>(Arrays.asList(east_usa, center_canada, greenland)));
        //east_canada.setSeaConnections(new ArrayList<>(Arrays.asList(greenland)));

        west_usa.setNeighbors(new ArrayList<>(Arrays.asList(west_canada, center_canada, east_usa, mexico)));
        //west_usa.setSeaConnections(new ArrayList<>(Arrays.asList()));

        argentina.setNeighbors(new ArrayList<>(Arrays.asList(west_latina, brazil)));
        //argentina.setSeaConnections(new ArrayList<>(Arrays.asList()));

        brazil.setNeighbors(new ArrayList<>(Arrays.asList(argentina, west_latina, north_latina, west_africa)));
        //brazil.setSeaConnections(new ArrayList<>(Arrays.asList(west_africa)));

        west_latina.setNeighbors(new ArrayList<>(Arrays.asList(argentina, brazil, north_latina)));
        //west_latina.setSeaConnections(new ArrayList<>(Arrays.asList()));

        north_latina.setNeighbors(new ArrayList<>(Arrays.asList(mexico, west_latina, brazil)));
        //north_latina.setSeaConnections(new ArrayList<>(Arrays.asList()));

        great_britain.setNeighbors(new ArrayList<>(Arrays.asList(iceland, france_spain, germany, scandinavia)));
        //great_britain.setSeaConnections(new ArrayList<>(Arrays.asList(iceland, france_spain, germany, scandinavia)));

        iceland.setNeighbors(new ArrayList<>(Arrays.asList(greenland, great_britain, scandinavia)));
        //iceland.setSeaConnections(new ArrayList<>(Arrays.asList(greenland, great_britain, scandinavia)));

        germany.setNeighbors(new ArrayList<>(Arrays.asList(france_spain, italy, east_europe, great_britain, scandinavia)));
        //germany.setSeaConnections(new ArrayList<>(Arrays.asList(great_britain, scandinavia)));

        scandinavia.setNeighbors(new ArrayList<>(Arrays.asList(east_europe, iceland, great_britain, germany)));
        //scandinavia.setSeaConnections(new ArrayList<>(Arrays.asList(iceland, great_britain, germany)));

        italy.setNeighbors(new ArrayList<>(Arrays.asList(france_spain, germany, east_europe, north_africa)));
        //italy.setSeaConnections(new ArrayList<>(Arrays.asList(north_africa)));

        east_europe.setNeighbors(new ArrayList<>(Arrays.asList(scandinavia, germany, italy, middle_east, center_asia, west_russia)));
        //east_europe.setSeaConnections(new ArrayList<>(Arrays.asList()));

        france_spain.setNeighbors(new ArrayList<>(Arrays.asList(germany, italy, great_britain, west_africa)));
        //france_spain.setSeaConnections(new ArrayList<>(Arrays.asList(great_britain, west_africa)));

        center_africa.setNeighbors(new ArrayList<>(Arrays.asList(west_africa, east_africa, south_africa)));
        //center_africa.setSeaConnections(new ArrayList<>(Arrays.asList()));

        east_africa.setNeighbors(new ArrayList<>(Arrays.asList(north_africa, west_africa, center_africa, south_africa, middle_east, madagascar)));
        //east_africa.setSeaConnections(new ArrayList<>(Arrays.asList(middle_east, madagascar)));

        north_africa.setNeighbors(new ArrayList<>(Arrays.asList(west_africa, east_africa, middle_east, italy)));
        //north_africa.setSeaConnections(new ArrayList<>(Arrays.asList(italy)));

        madagascar.setNeighbors(new ArrayList<>(Arrays.asList(east_africa, south_africa)));
        //madagascar.setSeaConnections(new ArrayList<>(Arrays.asList(east_africa, south_africa)));

        west_africa.setNeighbors(new ArrayList<>(Arrays.asList(north_africa, east_africa, center_africa, brazil, france_spain)));
        //west_africa.setSeaConnections(new ArrayList<>(Arrays.asList(brazil, france_spain)));

        south_africa.setNeighbors(new ArrayList<>(Arrays.asList(center_africa, east_africa, madagascar)));
        //south_africa.setSeaConnections(new ArrayList<>(Arrays.asList(madagascar)));

        center_asia.setNeighbors(new ArrayList<>(Arrays.asList(east_europe, west_russia, middle_east, india, china)));
        //center_asia.setSeaConnections(new ArrayList<>(Arrays.asList()));

        china.setNeighbors(new ArrayList<>(Arrays.asList(center_asia, india, thailand, mongolia, west_russia, center_russia)));
        //china.setSeaConnections(new ArrayList<>(Arrays.asList()));

        india.setNeighbors(new ArrayList<>(Arrays.asList(middle_east, center_asia, china, thailand)));
        //india.setSeaConnections(new ArrayList<>(Arrays.asList()));

        south_russia.setNeighbors(new ArrayList<>(Arrays.asList(center_russia, mongolia, north_russia, east_russia)));
        //south_russia.setSeaConnections(new ArrayList<>(Arrays.asList()));

        japan.setNeighbors(new ArrayList<>(Arrays.asList(mongolia, east_russia)));
        //japan.setSeaConnections(new ArrayList<>(Arrays.asList(mongolia, east_russia)));

        east_russia.setNeighbors(new ArrayList<>(Arrays.asList(north_russia, south_russia, mongolia, japan, alaska)));
        //east_russia.setSeaConnections(new ArrayList<>(Arrays.asList(japan, alaska)));

        middle_east.setNeighbors(new ArrayList<>(Arrays.asList(north_africa, italy, east_europe, center_asia, india, east_africa)));
        //middle_east.setSeaConnections(new ArrayList<>(Arrays.asList(east_africa)));

        mongolia.setNeighbors(new ArrayList<>(Arrays.asList(center_russia, china, south_russia, east_russia, japan)));
        //mongolia.setSeaConnections(new ArrayList<>(Arrays.asList(japan)));

        thailand.setNeighbors(new ArrayList<>(Arrays.asList(india, china, polynesia)));
        //thailand.setSeaConnections(new ArrayList<>(Arrays.asList(polynesia)));

        center_russia.setNeighbors(new ArrayList<>(Arrays.asList(west_russia, china, north_russia, south_russia, mongolia)));
        //center_russia.setSeaConnections(new ArrayList<>(Arrays.asList()));

        west_russia.setNeighbors(new ArrayList<>(Arrays.asList(east_europe, center_asia, china, center_russia)));
        //west_russia.setSeaConnections(new ArrayList<>(Arrays.asList()));

        north_russia.setNeighbors(new ArrayList<>(Arrays.asList(center_russia, south_russia, east_russia)));
        //north_russia.setSeaConnections(new ArrayList<>(Arrays.asList()));

        east_australia.setNeighbors(new ArrayList<>(Arrays.asList(west_australia, new_zealand)));
        //east_australia.setSeaConnections(new ArrayList<>(Arrays.asList(new_zealand)));

        polynesia.setNeighbors(new ArrayList<>(Arrays.asList(thailand, west_australia, new_zealand)));
        //polynesia.setSeaConnections(new ArrayList<>(Arrays.asList(thailand, west_australia, new_zealand)));

        new_zealand.setNeighbors(new ArrayList<>(Arrays.asList(polynesia, west_australia, east_australia)));
        //new_zealand.setSeaConnections(new ArrayList<>(Arrays.asList(polynesia, west_australia, east_australia)));

        west_australia.setNeighbors(new ArrayList<>(Arrays.asList(east_australia, polynesia, new_zealand)));
        //west_australia.setSeaConnections(new ArrayList<>(Arrays.asList(polynesia, new_zealand)));

        // On met les territoires dans des listes qui correspondent aux régions
        ArrayList<Territory> north_america_territories = new ArrayList<>(Arrays.asList(
                alaska, west_canada, mexico, east_usa, greenland, north_canada,
                center_canada, east_canada, west_usa));
        /*
        Pareil que :
        ArrayList<Territory>  north_america_territories = new ArrayList<>();
        north_america_territories.addAll(Arrays.asList(alaska, west_canada, mexico, east_usa,
                greenland, north_canada, center_canada, east_canada, west_usa));
         */

        ArrayList<Territory> south_america_territories = new ArrayList<>(Arrays.asList(
                argentina, brazil, west_latina, north_latina));

        ArrayList<Territory> europe_territories = new ArrayList<>(Arrays.asList(
                great_britain, iceland, germany, scandinavia, italy,
                east_europe, france_spain));

        ArrayList<Territory> africa_territories = new ArrayList<>(Arrays.asList(
                center_africa, east_africa, north_africa, madagascar, west_africa,
                south_africa));

        ArrayList<Territory> asia_territories = new ArrayList<>(Arrays.asList(
                center_asia, china, india, south_russia, japan, east_russia,
                middle_east, mongolia, thailand, center_russia, west_russia,
                north_russia));

        ArrayList<Territory> oceania_territories = new ArrayList<>(Arrays.asList(
                east_australia, polynesia, new_zealand, west_australia));

        // On met ces listes de territoires dans les régions
        north_america.setTerritories(north_america_territories);
        south_america.setTerritories(south_america_territories);
        europe.setTerritories(europe_territories);
        africa.setTerritories(africa_territories);
        asia.setTerritories(asia_territories);
        oceania.setTerritories(oceania_territories);

        // On ajoute les régions au plateau
        this.regions.addAll(Arrays.asList(north_america, south_america, europe, africa, asia, oceania));
        /*
        Pareil que :
        this.regions.add(north_america);
        this.regions.add(south_america);
        this.regions.add(europe);
        this.regions.add(africa);
        this.regions.add(asia);
        this.regions.add(oceania);
         */
    }

    /**
     * Instanciation des missions
     */
    private void missionsInitialization() {

        // Création de toutes les missions
        Mission mission_1 = new Mission("Destruction", "Vous devez détruire le joueur ", 3, 6);
        Mission mission_2 = new Mission("Conquête", "Vous devez conquérir tous les territoires", 2, 3);
        Mission mission_3 = new Mission("Contrôle 1", "Vous devez contrôler 3 régions et au moins 18 territoires", 1, 6);
        Mission mission_4 = new Mission("Contrôle 2", "Vous devez contrôler 18 territoires avec au moins 2 unités", 3, 6);
        Mission mission_5 = new Mission("Contrôle 31", "Vous devez contrôler 30 territoires", 2, 3);
        Mission mission_6 = new Mission("Contrôle 32", "Vous devez contrôler 24 territoires", 4, 5);
        Mission mission_7 = new Mission("Contrôle 33", "Vous devez contrôler 21 territoires", 6, 6);
        Mission mission_8 = new Mission("Contrôle 4", "Vous devez contrôler la région la plus grosse et une autre région", 1, 6);

        this.missions.addAll(Arrays.asList(mission_1, mission_2, mission_3, mission_4, mission_5, mission_6, mission_7, mission_8));
        this.setMissions(missions);
    }

    /**
     * Instanciation des joueurs
     *
     * @param players_nb nombre de joueurs dans la partie
     */
    public void generatePlayers(int players_nb) {
        int start_stock = this.startStock(players_nb);
        for (int k = 0; k < players_nb; k++) {
            System.out.print("Nom du joueur " + (k + 1) + " - NOSECU : ");
            String name = scan.nextLine();
            Player player = new Player(name, start_stock);
            this.players.add(player);
        }
    }

    /**
     * Détermine le nombre d'unités pour chaque joueur au début de la partie
     *
     * @param players_nb nombre de joueurs dans la partie
     * @return nombre d'unités pour chaque joueur
     */
    private int startStock(int players_nb) {
        switch (players_nb) {
            case 2:
                return 40;
            case 3:
                return 35;
            case 4:
                return 30;
            case 5:
                return 25;
            case 6:
                return 20;
            default:
                return -1;
        }
    }

    /**
     * Affiche chaque joueur avec le nombre d'unités qu'il a en stock
     */
    public void showPlayers() {
        System.out.println();
        System.out.println("----- Liste des joueurs ----- ");
        for (int k = 0; k < this.players.size(); k++) {
            System.out.println("Joueur " + (k + 1) + " : " + this.players.get(k).getName() +
                    " (stock : " + this.players.get(k).getUnitsStock() + ")");
        }
        System.out.println();
    }

    /**
     * Répartit les territoires entre les joueurs au début de la partie
     */
    public void territoriesRepartition() {
        ArrayList<Territory> territories = this.getTerritories();
        int players_number = this.players.size();
        int counter = 0;
        while (territories.size() > 0) {
            // On "pioche" un territoire dans la liste puis on le supprime de la liste
            int random_index = (int) (Math.random() * territories.size());
            territories.get(random_index).setPlayer(this.players.get(counter % players_number));
            territories.remove(random_index);
            counter++;
        }
    }

    /**
     * Forme une liste de tous les territoires de la carte
     *
     * @return liste de tous les territoires
     */
    private ArrayList<Territory> getTerritories() {
        ArrayList<Territory> territories = new ArrayList<>();

        // On parcourt les régions
        for (int i = 0; i < this.regions.size(); i++) {
            ArrayList<Territory> region_territories = regions.get(i).getTerritories();

            // Dans chaque région, on parcourt les territoires et on les met dans la liste
            for (int j = 0; j < region_territories.size(); j++) {
                territories.add(region_territories.get(j));
                //System.out.println(region_territories.get(j).getName());
            }
        }
        return territories;
    }

    /**
     * Affiche l'état actuel de la carte, c'est-à-dire :
     * - le propriétaire de chaque territoire
     * - le nombre d'unités présentes sur chaque territoire
     */
    public void showMap() {
        System.out.println("----- Etat actuel de la carte -----");
        for (int k = 0; k < this.regions.size(); k++) {
            this.regions.get(k).showRegion();
        }
    }

    public ArrayList<Region> getRegions() {
        return this.regions;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void missionsRepartition() {
        ArrayList<Mission> possibleMissions = new ArrayList<>();
        int players_number = this.players.size();

        for (int index = 0; index < this.missions.size(); index++) {
            if (this.missions.get(index).getPlayersNbMin() <= players_number && this.missions.get(index).getPlayersNbMax() >= players_number) {
                //System.out.println("mission ajoutée : " + this.missions.get(index).getName());
                possibleMissions.add(this.missions.get(index));
            }
        }

        this.setMissions(possibleMissions);
        missionsRepartitionRandom();
    }

    public void missionsRepartitionRandom() {
        //System.out.println(this.missions.size() + "/ " + this.players.size());
        int counter = 0;
        int numberMission = this.players.size();
        while (counter < this.players.size()) {
            // On "pioche" une mission dans la liste puis on le supprime de la liste
            int random_index = (int) (Math.random() * this.missions.size());
            int random_player = (int) (Math.random() * this.players.size());
            this.players.get(counter).setMission(this.missions.get(random_index));
            //System.out.println("Joueur : " + this.getPlayers().get(counter).getName() + " // Mission : " + this.missions.get(random_index).getName());
            if (!this.missions.get(random_index).getName().equals("Destruction")) {
                this.missions.remove(random_index);
            } else {
                System.out.println(random_player);
                System.out.println(this.players.size());
                if (random_player == counter && random_player >= this.players.size() - 2) {
                    random_player--;
                } else if (random_player == counter && random_player <= this.players.size() - 2) {
                    random_player++;
                }
                DestructMission destructMission = new DestructMission(this.players.get(counter).getMission().getName(), this.players.get(counter).getMission().getContent(), this.players.get(counter).getMission().getPlayersNbMin(), this.players.get(counter).getMission().getPlayersNbMax(), this.getPlayers().get(random_player));
                this.players.get(counter).setMission(destructMission);
                if (this.missions.size() > this.players.size()) {
                    this.missions.remove(random_index);
                }

            }
            counter++;
        }

    }


    public void showMissionsRepartition() {
        System.out.println("----- Etat actuel de la répartition des missions -----");
        for (int k = 0; k < this.players.size(); k++) {
            System.out.print("Joueur : " + this.players.get(k).getName());
            this.players.get(k).getMission().showMission();
        }
    }


    public ArrayList<Mission> getMissions() {
        return missions;
    }

    public void setMissions(ArrayList<Mission> missions) {
        this.missions = missions;
    }
}
