package base_code.mattfeldL-refactor.dungeon.characters.heroes;
import base_code.mattfeldL-refactor.dungeon.characters.DungeonCharacter;

import java.util.Scanner;

public class Thief extends Hero
{

    Thief()
	{
		super("Thief", "Surprise Attack", 75, 6, .8, 20, 40, .5);
    }//end constructor

	public void specialAction(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								characterName + " gets an additional turn.");
			numTurns++;
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method

}