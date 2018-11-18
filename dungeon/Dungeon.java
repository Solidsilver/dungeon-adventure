package dungeon;

import java.io.Serializable;
import java.util.*;

public class Dungeon implements Serializable {
    private static final long serialVersionUID = 1L;
    private int seed;

    public Dungeon() {
        Random rnd = new Random();
        seed = rnd.nextInt(10000000);
    }

    public String toString() {
        return "Seed: " + this.seed + " ";
    }

    public ArrayList<String> moveOptions() {
        return null;
    }
    
}