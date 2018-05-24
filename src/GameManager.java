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

        // TODO: Distribution des missions ici

        // Répartition des territoires entre les joueurs
        this.board.territoriesRepartition();

        board.showMap();

        // Placement des unités (l'un après l'autre, les joueurs placent toutes leurs unités)
        for (int k = 0; k < players.size(); k++) {
            players.get(k).repartUnits(regions);
        }

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

}
