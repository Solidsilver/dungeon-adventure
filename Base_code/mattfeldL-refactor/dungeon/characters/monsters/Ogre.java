package dungeon.characters.monsters;
import dungeon.characters.DungeonCharacter;

public class Ogre extends Monster
{

    Ogre()
	{
		super("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50);
    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(characterName + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class