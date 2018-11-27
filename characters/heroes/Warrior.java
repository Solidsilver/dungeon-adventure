package characters.heroes;
<<<<<<< HEAD
import characters.DungeonCharacter;
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
=======

public class Warrior extends Hero{

	private static final String WarriorName = "Warrior";
	private static final int WarriorHitPoints = 125;
	private static final int WarriorAttackSpeed = 4;
	private static final double WarriorChanceToHit = 0.8;
	private static final int WarriorDamageMin = 35;
	private static final int WarriorDamageMax = 60;
	private static final double WarriorChanceToBlock = 0.2;
	
	public Warrior()
	{
		super(WarriorName, WarriorHitPoints, WarriorAttackSpeed, WarriorChanceToHit,
				WarriorDamageMin, WarriorDamageMax, WarriorChanceToBlock, "Crushing Blow");
	
    }//end constructor
	
}
>>>>>>> DAcharacter
