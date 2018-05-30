import java.util.*;

public class GameManager {

    static Scanner scan = new Scanner(System.in);

    private Board board;

    public GameManager() {
        this.board = new Board();
    }

    public void launchGame() {

        // Création des joueurs
        System.out.print("Nombre de joueurs (entre 2 et 6) - NOSECU : ");
        int players_nb = scan.nextInt();

        this.board.generatePlayers(players_nb);
        this.board.showPlayers();

        ArrayList<Region> regions = this.board.getRegions();
        ArrayList<Player> players = this.board.getPlayers();

        // Répartition des territoires entre les joueurs
        this.board.territoriesRepartition();

        // Répartition des missions entre les joueurs
        this.board.missionsRepartition();

        // Affichage de la répartition des missions
        this.board.showMissionsRepartition();

        // Placement d'une unité sur chaque territoire puis du reste des soldats
        for (int k = 0; k < players.size(); k++) {
            players.get(k).repartUnitsInitialisation(regions);
            players.get(k).repartUnitsfirsttour(regions);
        }


        board.showMap();

        //gestion des déplacements et attaques



        // Donner des renforts aux joueurs
        for (int playersCounter = 0; playersCounter < players_nb; playersCounter++) {
            this.giveBackupPlayer(this.board.getPlayers().get(playersCounter), 0);
        }

        for (int k = 0; k < players.size(); k++) {
            players.get(k).repartUnits(regions); //TODO fonction encore à revoir
        }

        board.showMap();


        //this.testConfig();

    }

    /**
     * Petit fonction qui initialise quelques trucs pour faire des tests
     */
    public void testConfig() {

        ArrayList<Region> regions = this.board.getRegions();
        ArrayList<Player> players = this.board.getPlayers();

        Player player1 = players.get(0);
        Player player2 = players.get(1);

        // On prend 2 territoires, on les donne à 2 joueurs différents
        Territory ter1 = regions.get(0).getTerritories().get(0);
        Territory ter2 = regions.get(0).getTerritories().get(1);
        ter1.setPlayer(player1);
        ter2.setPlayer(player2);

        // On ajoute des unités sur chaque territoire
        ArrayList<Unit> units1 = new ArrayList<>(Arrays.asList(
                new Soldier(), new Cannon(), new Horseman()));
        ArrayList<Unit> units2 = new ArrayList<>(Arrays.asList(
                new Horseman(), new Soldier()));
        ter1.setUnits(units1);
        ter2.setUnits(units2);

        // On lance une attaque
        player1.launchAttack(ter1, ter2);


    }

    public void giveBackupPlayer(Player player, int counterNewTerritory) {
        int backupUnits = 0;
        // Comptage des territoires

        backupUnits += player.territoryPlayerCounter(this.board.getRegions()) / 3; // à changer en fonction du tour du joueur

        for (int regionCounter = 0; regionCounter < this.board.getRegions().size(); regionCounter++) {
            int counter = 0;
            for (int territoryCounter = 0; territoryCounter < this.board.getRegions().get(regionCounter).getTerritories().size(); territoryCounter++) {
                if (this.board.getRegions().get(regionCounter).getTerritories().get(territoryCounter).getPlayer().getName().equals(player.getName())) {
                    counter++;
                }
            }
            if (counter == this.board.getRegions().get(regionCounter).getTerritories().size()) {
                backupUnits += this.board.getRegions().get(regionCounter).getTerritories().size() / 2;
            }
        }
        if (counterNewTerritory > 0) {
            for (int i = 0; i < counterNewTerritory; i++) {
                int random_number = (int) (Math.random()*2);
                //System.out.println("le nombre aléatoire vaut : " + random_number);
                if (random_number == 1) {
                    backupUnits++;
                }
            }
        }

        if (backupUnits <= 2) {
            backupUnits = 2;
        }
        //System.out.println("Le nombre de renforts est :"+backupUnits);
        player.setUnits_stock(backupUnits);
    }


}
