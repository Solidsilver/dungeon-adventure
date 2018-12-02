package characters.heroes;
import java.util.ArrayList;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class HeroFactory {
	private ArrayList<String> types;

    public HeroFactory() {
        this.types = new ArrayList<>();
		types.add("Warrior");
		types.add("Sorceress");
		types.add("Thief");
		types.add("Stu The Steiner");
		types.add("Tom The Capaul");
        
    }
	public Hero makeHero(int type)
	{
		switch(type)
		{
		case 0: 
			return new Warrior();
		case 1: 
			return new Sorceress();
		case 2: 
			return new Thief();
		case 3: 
			return new StuTheSteiner();
		case 4:
			return new TomTheCapaul();
		default:
			return new Thief();
		}
	}

	public Hero makeHero(String type) {
        //Hero newHero;
        type = type.toLowerCase();
        type = type.substring(0, 1).toUpperCase() + type.substring(1);
        return makeHero(this.types.indexOf(type));
    }

	public ArrayList<String> getOptions() {
        return this.types;
    }
	
}
