package dungeon;

import java.io.Serializable;
import java.util.Random;

public class Dungeon implements Serializable {
    private int seed;

    public Dungeon() {
        Random rnd = new Random();
        seed = rnd.nextInt(10000000);
    }

    public String toString() {
        return "Seed: " + this.seed + " ";
    }
    
}