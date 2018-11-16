import dungeon.Dungeon;
public class Game {
    private Dungeon dungeon;
    private PlayerController pController;

    public Game() {
        this.dungeon = new Dungeon();
        this.pController = new PlayerController();
    }
}