package characters.heroes;
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
