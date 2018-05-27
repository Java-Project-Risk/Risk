public class Mission {

    protected String name;
    protected String content;
    protected int players_nb_min;
    protected int players_nb_max;

    public Mission(String name, String content, int players_nb_min, int players_nb_max) {
        this.name = name;
        this.content = content;
        this.players_nb_min = players_nb_min;
        this.players_nb_max = players_nb_max;
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPlayersNbMin() {
        return this.players_nb_min;
    }

    public int getPlayersNbMax() {
        return this.players_nb_max;
    }

    public void showMission() {
        System.out.println();
        System.out.println("Nom de la mission : " + this.name);
        System.out.println("Contenu mission : " +  this.content);
        System.out.println("Nombre minimum de joueur : " +  this.players_nb_min);
        System.out.println("Nombre maximum de joueur : " +  this.players_nb_max);
        System.out.println();
    }
}
