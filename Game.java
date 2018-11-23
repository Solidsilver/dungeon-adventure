import java.io.Serializable;
import java.util.Random;

import dungeon.Dungeon;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private Dungeon dungeon;
    private PlayerController pController;
    private boolean isGameOver;

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
        this.isGameOver = false;
    }

    /*private boolean isGameOver() {
        if (this.isGameOver) {
            Random rnd = new Random();
            int again = rnd.nextInt(20);
            switch (again) {
            case 3:
                this.isGameOver = true;
            default:
                break;
            }
        }

        return this.isGameOver;
    }*/

    public void gameOver() {
        this.isGameOver = true;
    }

    private void playGame() {
        while (!this.isGameOver) {
            pController.playTurn();
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