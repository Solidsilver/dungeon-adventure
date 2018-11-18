import java.io.Serializable;
import java.util.Random;

import dungeon.Dungeon;
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private Dungeon dungeon;
    private PlayerController pController;

    public void start() {
        init();
        playGame();
        endGame();
    }

    private void init() {
        if (this.dungeon == null && this.pController == null) {
            this.dungeon = new Dungeon();
            this.pController = new PlayerController(this);
        }
    }

    private boolean isGameOver() {
        Random rnd = new Random();
        int again = rnd.nextInt(20);
        switch (again) {
            case 3:
                return true;        
            default:
                break;
        }
        return false;
    }

    private void playGame() {
        while (pController.playTurn()) {
            //pController.playTurn();
        }
    }

    private void endGame() {
        System.out.println("Game Over");
    }

    public String toString() {
        return "Dungeon" + dungeon + "PController: " + pController;
    }

    public void saveCurrent() {
        DungeonAdventure.saveGame(this);
    }

}