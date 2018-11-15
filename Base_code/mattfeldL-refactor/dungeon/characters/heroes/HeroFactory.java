package dungeon.characters.heroes;

public class HeroFactory {
    public Hero createHero(String type) {
        Hero newHero;
        type = type.toLowerCase();
        
        if (type.equals("sorceress")) {
            newHero = new Sorceress();
        } else if (type.equals("thief")) {
            newHero = new Thief();
        } else if (type.equals("warrior")) {
            newHero = new Warrior();
        } else {
            throw new IllegalArgumentException("Type " + type + " not found");
        }
        return newHero;
    }
}