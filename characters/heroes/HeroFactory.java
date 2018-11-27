package characters.heroes;
<<<<<<< HEAD
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
        //Hero newHero;
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
=======
public class HeroFactory {

	public Hero makeHero(int type)
	{
		switch(type)
		{
		case 1: 
			return new Warrior();
		case 2: 
			return new Sorceress();
		case 3: 
			return new Thief();
		case 4: 
			return new StuTheSteiner();
		case 5:
			return new TomTheCapaul();
		default:
			return new Thief();
		}
	}
	
}
>>>>>>> DAcharacter
