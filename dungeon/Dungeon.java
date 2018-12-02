package dungeon;

import java.io.Serializable;
import java.util.*;
import characters.heroes.*;
import characters.monsters.*;
import dungeon.room.*;
import pickups.*;
import utils.Print;
import exceptions.*;

public class Dungeon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int MAPSMAX_X = 4; // 1 based
    private int MAPSMAX_Y = 4; // 1 based
    private int seed;
    private Room[][] map;
    private Hero hero;
    private int heroX, heroY;

    public Dungeon(Hero hero) {
        this.hero = hero;
        this.map = DungeonMapFactory.createDungeonMap(MAPSMAX_Y, MAPSMAX_X, this);
        if (!findEntrance()) {
            throw new RoomNotFoundException("There is not entrance");
        }
    }

    private boolean findEntrance() {
        for (int y = 0; y < this.MAPSMAX_Y; y++) {
            for (int x = 0; x < this.MAPSMAX_X; x++) {
                if (this.map[y][x].hasEntrance()) {
                    this.heroY = y;
                    this.heroX = x;
                    return true;
                }
                // System.out.print("[Rm]");
            }
            // System.out.println();
        }
        return false;
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
        MonsterFactory mf = new MonsterFactory();
        Monster monster = mf.makeMonster(new Random().nextInt(4) + 1);
        battle(this.hero, monster);
    }

    private static void battle(Hero theHero, Monster theMonster) {
        System.out.println("There's a monster in the room!");
        // hero goes first
        do {
            theHero.battleChoices(theMonster);

            // monster's turn (provided it's still alive!)
            if (theMonster.isAlive())
                theMonster.attack(theHero);
        } while (theHero.isAlive() && theMonster.isAlive());

    }// end battle method

    public boolean roomHasPit() {
        return this.map[heroY][heroX].hasPit();
    }

    public void fallInPit() {
        int pitDamage = this.map[heroY][heroX].getPitsRandomHitPointDamage();
        this.hero.subtractHitPoints(pitDamage);
    }

    public ArrayList<PickupItem> getRoomContents() {
        return map[this.heroY][this.heroX].roomsContents;
    }

    public boolean playerAtEnd() {
        return this.map[heroY][heroX].isExit();
    }

    public void movePlayer(int direction) {
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
            this.setHeroX(this.getHeroX() + 1);
            break;
        default:
            break;
        }
    }

    public void printPlayerLocation() {
        Print.roomsUsingVisionPotion(this.map, this.heroX, this.heroY);
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

        switch (direction) {

        case 0: // North
            if (heroY > 0)
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

    public void printFullDungeon() {
        Print.fullMap(this.map, this.heroX, this.heroY);
    }

}