import java.io.Serializable;
import java.util.Random;

import dungeon.Dungeon;
import characters.heroes.*;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private Hero hero;
    private Dungeon dungeon;
    private PlayerController pController;
    private boolean isGameOver;

    public void start() {
        init();
        int endType = playGame();
        endGame(endType);
    }

    private void init() {
        if (this.dungeon == null && this.pController == null && this.hero == null) {
            this.hero = PlayerController.initHero();
            this.dungeon = new Dungeon(hero);
            this.pController = new PlayerController(this, this.hero);
        }
        this.isGameOver = false;
    }

    public void gameOver() {
        this.isGameOver = true;
    }

    private int playGame() {
        int returnFlag = 0;
        while (!this.isGameOver) {
            if (this.dungeon.roomHasMonster()) {
                this.dungeon.beginBattle();
            }
            if (!hero.isAlive()) {
                return 1;
            }
            if (this.dungeon.roomHasPit()) {
                this.dungeon.fallInPit();
            }
            if (!hero.isAlive()) {
                return 1;
            }
            this.hero.addToInventory(this.dungeon.getRoomContents());
            if (this.dungeon.playerWon()) {
                return 2;
            }
            returnFlag = pController.playTurn();
        }
        return returnFlag;
    }

    private void endGame(int endType) {
        switch (endType) {
            case 0:
                System.out.println("Come again soon");
                break;
            case 1:
                System.out.println("You died! Try again...");
                break;
            case 2:
                System.out.println("Congratulations! You won.");
            default:
                break;
        }

        System.out.println("Game Over");
    }

    public String toString() {
        return "Dungeon" + dungeon + "PController: " + pController;
    }

    public void saveCurrent() {
        DungeonAdventure.saveGame(this);
    }

    public ArrayList<String> getDirections() {
        return this.dungeon.moveOptions();
    }

    public void movePlayer(int dir) {
        this.dungeon.movePlayer(dir);
    }

}