package characters.heroes;
<<<<<<< HEAD
import characters.DungeonCharacter;

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
=======

import Attack.IAttack;

public class Thief extends Hero{

	private static final String ThiefName = "Thief";
	private static final int ThiefHitPoints = 75;
	private static final int ThiefAttackSpeed = 6;
	private static final double ThiefChanceToHit = 0.8;
	private static final int ThiefDamageMin = 20;
	private static final int ThiefDamageMax = 40;
	private static final double ThiefChanceToBlock = 0.5;
	
	public Thief()
	{
		super(ThiefName, ThiefHitPoints, ThiefAttackSpeed, ThiefChanceToHit, ThiefDamageMin,
				ThiefDamageMax, ThiefChanceToBlock, "Surprise Attack");
		
    }//end constructor
	
}
>>>>>>> DAcharacter
