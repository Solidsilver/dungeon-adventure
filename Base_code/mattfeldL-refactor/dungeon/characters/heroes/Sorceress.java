package base_code.mattfeldL-refactor.dungeon.characters.heroes;
import base_code.mattfeldL-refactor.dungeon.characters.DungeonCharacter;

import java.util.Scanner;

public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

//-----------------------------------------------------------------
    Sorceress()
	{
		super("Sorceress", "Increase Hit Points", 75, 5, .7, 25, 50, .3);
    }//end constructor

//-----------------------------------------------------------------
	public void specialAction(DungeonCharacter opponent)
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		inflictDamage(hPoints);
		System.out.println(characterName + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ healthPoints);
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(characterName + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method


}//end class