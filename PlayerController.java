import characters.heroes.*;
import java.io.*;
import java.util.Scanner;
import utils.*;

public class PlayerController implements Serializable {
    private static final long serialVersionUID = 2L;
    private Hero hero;
    private Game game;

    public PlayerController(Game game, Hero hero) {
        this.hero = hero;
        this.game = game;
    }

    public static Hero initHero() {
        Menu heroSelection ;//= new Menu("Choose a Character:", "Warrior", "Theif", "Sorceress");
        HeroFactory hf = new HeroFactory();
        heroSelection = new Menu("Choose a Character: ", hf.getOptions());
        int choice = heroSelection.getSelectionDefault();
        return hf.makeHero(choice);
    }

    public int playTurn() {
        Menu mnu = new Menu("~~~Play~~~", "Change Room", "Inventory", "Save Game", "Exit");
        int choice = mnu.getSelectionDefault();

        switch (choice) {
            case 0:
                changeRoom();
                break;
            case 1:
                inventory();
                break;
            case 2:
                DungeonAdventure.saveGame(this.game);
                break;
            case 3:
                this.game.gameOver();
                return 0;
            default:
                break;
        }
        return -1;
    }

    private void changeRoom() {
        Menu rooms = new Menu("Rooms", this.game.getDirections());
        int choice = rooms.getSelectionDefault();
        rooms.add("Back");
        if (!rooms.isLast(choice)) {
            this.game.movePlayer(choice);
        }
    }

    private void inventory() {
        Menu mnu = new Menu(this.hero.getName() + "'s Inventory", this.hero.inventoryToString());
        mnu.add("Back");
        int choice = mnu.getSelectionDefault();
        if (!mnu.isLast(choice)) {
            this.hero.useItem(choice - 1);
        }
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}