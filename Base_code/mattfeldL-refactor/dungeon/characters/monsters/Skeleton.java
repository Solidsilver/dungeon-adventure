package dungeon.characters.monsters;
import dungeon.characters.DungeonCharacter;

public class Skeleton extends Monster
{

    Skeleton()
	{
		super("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50);

    }//end constructor

	@Override
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(characterName + " slices his rusty blade at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Skeleton