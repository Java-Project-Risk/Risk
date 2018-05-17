import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //TODO: Attribution des missions aux joueurs

        //TODO: Répartition des territoires entre les joueurs

        //TODO: Placement des unités (à tour de rôle, min 1 unité par territoire)
        // Est-ce qu'on a le droit de placer des cavaliers ou des canons au début ?

        /*
        TODO: phase tour par tour
                - réception des renforts
                - placement des unités
                - attaques et déplacements éventuels
         */

        GameManager game_manager = new GameManager();
        game_manager.launchGame();

    }
}
