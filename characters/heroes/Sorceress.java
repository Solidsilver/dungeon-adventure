package characters.heroes;
<<<<<<< HEAD
import characters.DungeonCharacter;

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
=======

public class Sorceress extends Hero{

	private static final String SorceressName = "Sorceress";
	private static final int SorceressHitPoints = 75;
	private static final int SorceressAttackSpeed = 5;
	private static final double SorceressChanceToHit = 0.7;
	private static final int SorceressDamageMin = 25;
	private static final int SorceressDamageMax = 50;
	private static final double SorceressChanceToBlock = 0.3;
	
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
    public Sorceress()
	{
		super(SorceressName, SorceressHitPoints, SorceressAttackSpeed, SorceressChanceToHit,
				SorceressDamageMin, SorceressDamageMax, SorceressChanceToBlock, 
				"Increase Hit Points");
    }//end constructor
    
    public int getMinAdd()
    {
    	return MIN_ADD;
    }
    
    public int getMaxAdd()
    {
    	return MAX_ADD;
    }
    

   
}
>>>>>>> DAcharacter
