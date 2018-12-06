/**
 * @author Luke Mattfeld
 */
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
        Menu.clearScreen();
        Menu heroSelection;// = new Menu("Choose a Character:", "Warrior", "Theif", "Sorceress");
        HeroFactory hf = new HeroFactory();
        heroSelection = new Menu("Choose a Character: ", hf.getOptions());
        int choice = heroSelection.getSelection(2, false);
        return hf.makeHero(choice);
    }

    public int playTurn() {
        Menu mnu = new Menu("~~~Play~~~", "Change Room", "Inventory", "Stats", "Save Game", "Exit", "Developer Options");
        int choice = mnu.getSelection(3);
        //Menu.clearScreen();
        switch (choice) {
        case 0:
            Menu.clearScreen();
            changeRoom();
            Menu.clearScreen();
            break;
        case 1:
            Menu.clearScreen();
            inventory();
            //Menu.clearScreen();
            break;
        case 2:
            Menu.clearScreen();
            System.out.println(this.hero);
            break;
        case 3:
            Menu.clearScreen();
            DungeonAdventure.saveGameDefault(this.game);
            break;
        case 4:
            Menu.clearScreen();
            this.game.gameOver();
            return 0;
        case 5:
            //System.out.println("dev unlocked");
            this.game.devOptions();
            Menu.clearScreen();
            break;
        default:
            break;
        }
        return -1;
    }

    private void changeRoom() {
    	
        Menu moveOptions = new Menu("Rooms", "North", "South", "East ", "West");
        moveOptions.add("Back");
        int choice;
        boolean lastMoveValid = true;
        do {
            if (!lastMoveValid) {
                System.out.println("Invalid Move");
            }
            choice = moveOptions.getSelection(2, false);
            lastMoveValid = this.game.isMoveValid(choice);
        } while (!moveOptions.isLast(choice) && !lastMoveValid);
        if (!moveOptions.isLast(choice)) {
            this.game.movePlayer(choice);
        }
        //Menu.clearScreen();
    }

    private void inventory() {
        Menu mnu = new Menu(this.hero.getName() + "'s Inventory", this.hero.inventoryToString());
        mnu.add("Back");
        int choice = mnu.getSelection(2, false);
        //Menu.clearScreen();
        if (!mnu.isLast(choice)) {
            this.hero.useItem(choice);
        }
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}