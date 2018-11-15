package dungeon.characters.heroes;
import dungeon.characters.DungeonCharacter;

import java.util.Scanner;

public class Warrior extends Hero
{

    Warrior()
	{

		super("Warrior", "Crushing Blow on Opponent", 125, 4, .8, 35, 60, .2);


    }//end constructor


	public void specialAction(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(characterName + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.inflictDamage(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(characterName + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(characterName + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

}//end Hero class