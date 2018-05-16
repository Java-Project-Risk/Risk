import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Board board = new Board();

        for (int k = 0; k < board.regions.size(); k++) {
            System.out.println(board.regions.get(k).name);
        }

        System.out.println("Nombre de joueurs (entre 2 et 6) - NOSECU : ");
        int players_nb = scan.nextInt();

        board.generatePlayers(players_nb);
        board.showPlayers();

        //TODO: Attribution des missions aux joueurs

        //TODO: Répartition des territoires entre les joueurs
        board.territoriesRepartition();

        //TODO: Placement des unités (à tour de rôle, min 1 unité par territoire)
        // Est-ce qu'on a le droit de placer des cavaliers ou des canons au début ?

        /*
        TODO: phase tour par tour
                - réception des renforts
                - placement des unités
                - attaques et déplacements éventuels

        //Blabla
         */



    }
}
