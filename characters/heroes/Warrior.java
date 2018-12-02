package characters.heroes;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

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
