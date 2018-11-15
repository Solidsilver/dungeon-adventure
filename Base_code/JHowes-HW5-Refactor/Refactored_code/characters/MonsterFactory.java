package characters;

public class MonsterFactory {

	public static Monster createMonster() {
		
		int choice;
		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return new Ogre();
			case 2: return new Gremlin();
			case 3: return new Skeleton();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton();
		}
	}
}
