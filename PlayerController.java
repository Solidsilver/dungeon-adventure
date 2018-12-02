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
        Menu heroSelection;// = new Menu("Choose a Character:", "Warrior", "Theif", "Sorceress");
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
            DungeonAdventure.saveGameDefault(this.game);
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
        Menu moveOptions = new Menu("Rooms", "North", "South", "East", "West");
        moveOptions.add("Back");
        int choice;
        boolean lastMoveValid = true;
        do {
            if (!lastMoveValid) {
                System.out.println("Invalid Move");
            }
            choice = moveOptions.getSelectionDefault();
            lastMoveValid = this.game.isMoveValid(choice);
        } while (!moveOptions.isLast(choice) && !lastMoveValid);
        if (!moveOptions.isLast(choice)) {
            this.game.movePlayer(choice);
        }
    }

    private void inventory() {
        Menu mnu = new Menu(this.hero.getName() + "'s Inventory", this.hero.inventoryToString());
        mnu.add("Back");
        int choice = mnu.getSelectionDefault();
        if (!mnu.isLast(choice)) {
            this.hero.useItem(choice);
        }
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}