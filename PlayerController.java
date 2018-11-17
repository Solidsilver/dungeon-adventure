import characters.heroes.*;
import java.io.*;
import java.util.Scanner;

public class PlayerController implements Serializable {
    private Hero hero;

    public PlayerController() {
        HeroFactory hf = new HeroFactory();
        this.hero = hf.createHero("warrior");
    }

    public void playTurn() {
        Scanner kb = new Scanner(System.in);
        int ip = 0;
        System.out.println("Playing turn\nSay hi? (1/0): ");
        ip = Integer.parseInt(kb.nextLine());
        if (ip == 1) {
            System.out.println(this.hero.getName() + " says hi!");
        }
    }

    public String toString() {
        return "Hero: " + hero.getName();
    }
}