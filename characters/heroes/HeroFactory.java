package characters.heroes;
import java.util.ArrayList;

public class HeroFactory {
    private ArrayList<String> types;

    public HeroFactory() {
        this.types = new ArrayList<>();
        types.add("Warrior");
        types.add("Thief");
        types.add("Sorceress");
    }
    public Hero createHero(String type) {
        Hero newHero;
        type = type.toLowerCase();
        type = type.substring(0, 1).toUpperCase() + type.substring(1);
        return createHero(this.types.indexOf(type));
    }

    public Hero createHero(int typeID) {
        Hero newHero;

        switch (typeID) {
            case 0:
                newHero = new Warrior();
                break;
            case 1:
                newHero = new Thief();
                break;
            case 2:
                newHero = new Sorceress();
                break;
            default:
                newHero = new Thief();
                break;
        }

        return newHero;
    }

    public ArrayList<String> getOptions() {
        return this.types;
    }
}