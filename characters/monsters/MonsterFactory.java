package characters.monsters;
public class MonsterFactory {

	public Monster makeMonster(int type)
	{
		switch(type)
		{
		case 1: 
			return new Ogre();
		case 2: 
			return new Gremlin();
		case 3: 
			return new Skeleton();
		case 4:
			return new ChrisThePeters();
		case 5: 
			return new BrianTheCamp();
		default:
			return new Skeleton();
		}
	}
	
}
