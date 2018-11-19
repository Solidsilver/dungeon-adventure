import characters.heroes.*;
import java.io.*;
import java.util.Scanner;

public class PlayerController implements Serializable {
    private static final long serialVersionUID = 2L;
    private Hero hero;
    private Game game;

    public PlayerController(Game game) {
        this.hero = initHero();
        this.game = game;
    }

    private Hero initHero() {
        Menu heroSelection = new Menu("Choose a Character:", "Warrior", "Theif", "Sorceress");
        HeroFactory hf = new HeroFactory();
        int choice = heroSelection.getSelectionDefault();
        return hf.createHero(choice);
    }

    public void playTurn() {
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
            default:
                break;
        }
    }

    private void changeRoom() {
        Menu mnu;
    }

    private void inventory() {
        Menu mnu = new Menu(this.hero.getName() + "'s Inventory", this.hero.inventoryToString());
        mnu.add("Back");
        int choice = mnu.getSelectionDefault();
        if (!mnu.isLast(choice)) {
            this.hero.useInventoryItem(choice - 1);
        }
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}