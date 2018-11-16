import characters.HeroFactory;

public class PlayerController {
    private Hero hero;

    public PlayerController() {
        HeroFactory hf = new HeroFactory();
        this.hero = hf.createHero("Warrior");
    }
}