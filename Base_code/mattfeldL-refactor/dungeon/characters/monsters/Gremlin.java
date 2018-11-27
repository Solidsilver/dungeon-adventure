package base_code.mattfeldL-refactor.dungeon.characters.monsters;
import base_code.mattfeldL-refactor.dungeon.characters.DungeonCharacter;

public class Gremlin extends Monster
{

    Gremlin()
	{
		super("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(characterName + " jabs his kris at " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end class Gremlin