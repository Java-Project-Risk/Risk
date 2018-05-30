/**
 * Created by Romain on 25/05/2018.
 */

public class DestructMission extends Mission {
    protected Player targetedPlayer;

    public DestructMission(String name, String content, int players_nb_min, int players_nb_max, Player targetedPlayer) {
        super(name, content, players_nb_min, players_nb_max);
        this.content = content +=targetedPlayer.getName() ;
        this.targetedPlayer = targetedPlayer;
    }


    public Player getTargetedPlayer() {
        return targetedPlayer;
    }

    public void setTargetedPlayer(Player targetedPlayer) {
        this.targetedPlayer = targetedPlayer;
    }
    /*
    public void showDestructMission(){
        System.out.println();
        this.showMission();
        System.out.println("Le joueur à détruire est : " + this.getTargetedPlayer().getName());
        System.out.println();
    }
    */
}
