import java.io.Serializable;

import dungeon.Dungeon;
public class Game implements Serializable {
    private Dungeon dungeon;
    private PlayerController pController;

    public Game() {
        this.dungeon = new Dungeon();
        this.pController = new PlayerController();
    }

    public String toString() {
        return "Dungeon" + dungeon + "PController: " + pController;
    }

}