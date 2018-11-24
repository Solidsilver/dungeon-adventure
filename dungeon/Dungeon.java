package dungeon;

import java.io.Serializable;
import java.util.*;
import characters.heroes.*;
import dungeon.room.*;
import pickups.*;

public class Dungeon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int seed;
    private Room[][] map;
    private Hero hero;

    public Dungeon(Hero hero) {
        this.hero = hero;
        Random rnd = new Random();
        seed = rnd.nextInt(10000000);
        this.map = DungeonMapFactory.createDungeonMap(10, 10);
    }

    public String toString() {
        return "Seed: " + this.seed + " ";
    }

    public ArrayList<String> moveOptions() {
        return null;
    }

    public boolean roomHasMonster() {
        return false;
    }

    public void beginBattle() {

    }

    public boolean roomHasPit() {
        return false;
    }

    public void fallInPit() {

    }

    public ArrayList<PickupItem> getRoomContents() {
        return null;
    }

    public boolean playerWon() {
        return false;
    }
    
}