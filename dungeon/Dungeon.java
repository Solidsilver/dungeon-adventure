package dungeon;

import java.io.Serializable;
import java.util.*;
import characters.heroes.*;
import dungeon.room.*;
import pickups.*;

public class Dungeon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int MAPSMAX_X = 10; // 1 based
    private int MAPSMAX_Y = 10; // 1 based
    private int seed;
    private Room[][] map;
    private Hero hero;
    private int heroX, heroY;

    public Dungeon(Hero hero) {
        this.hero = hero;
        // Random rnd = new Random();
        // seed = rnd.nextInt(10000000);
        this.map = DungeonMapFactory.createDungeonMap(MAPSMAX_Y, MAPSMAX_X, this);
    }

    public String toString() {
        return "Seed: " + this.seed + " ";
    }

    public ArrayList<String> moveOptions() {
        // 0 - North, 1 - South, 2 - East, 3 - West
        return null;
    }

    public boolean roomHasMonster() {
        return this.map[heroY][heroX].hasMonster();
    }

    public void beginBattle() {

    }

    public boolean roomHasPit() {
        return this.map[heroY][heroX].hasPit();
    }

    public void fallInPit() {
        int pitDamage = this.map[heroY][heroX].getPitsRandomHitPointDamage();
        this.hero.subtractHitPoints(pitDamage);
    }

    public ArrayList<PickupItem> getRoomContents() {
        return null;
    }

    public boolean playerAtEnd() {
        return this.map[heroY][heroX].isExit();
    }

    public void movePlayer(int direction) {
        // [Y] [X] change
        // N is [-1][0]
        // S is [+1][0]
        // W is [0][-1]
        // E is [0][+1]

        int x = this.getHerosXCoord();
        int y = this.getHerosYCoord();

        // System.out.println("DEBUG --- printing this.getHerosXCoord() " +
        // this.getHerosXCoord() + "; printing this.getHerosYCoord() " +
        // this.getHerosYCoord() );
        switch (direction) {

        case 0:
            this.setHeroY(this.getHeroY() - 1);
            break;
        case 1:
            this.setHeroY(this.getHeroY() + 1);
            break;
        case 3:
            this.setHeroX(this.getHeroX() - 1);
            break;
        case 2:
            this.setHeroX(thid.getHeroX() + 1);
            break;
        default:
            break;
        }
    }

    public void printPlayerLocation() {

    }

    private void setHeroX(int x) {
        this.heroX = x;
    }

    private void setHeroY(int y) {
        this.heroY = y;
    }

    private int getHeroX() {
        return this.heroX;
    }

    private int getHeroY() {
        return this.heroY;
    }

    public boolean isMoveValid(int direction) {
        // [Y] [X] change
        // N is [-1][0]
        // S is [+1][0]
        // W is [0][-1]
        // E is [0][+1]
        switch (direction) {

        case 0: // North
            if (heroY - 1 >= 0)
                return true;
            else
                return false;
        case 1: // South
            if (heroY + 1 <= (MAPSMAX_Y - 1)) // MAPSMAX_Y - 1 so number is zero based.
                return true;
            else
                return false;
        case 3: // West
            if (heroX - 1 >= 0)
                return true;
            else
                return false;
        case 2: // East
            if (heroX + 1 <= (MAPSMAX_X - 1)) // MAPSMAX_X - 1 so number is zero based.
                return true;
            else
                return false;
        default:
            return false;
        }

    }

}