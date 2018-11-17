import characters.heroes.*;
import java.io.*;

public class PlayerController implements Serializable {
    private Hero hero;

    public PlayerController() {
        HeroFactory hf = new HeroFactory();
        this.hero = hf.createHero("warrior");
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}