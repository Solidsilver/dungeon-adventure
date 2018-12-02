package characters.monsters;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class BrianTheCamp extends Monster{

	private static final String BrianName = "Brian The Camp";
	private static final int BrianHitPoints = 90;
	private static final int BrianAttackSpeed = 4;
	private static final double BrianChanceToHit = 0.9;
	private static final double BrianChanceToHeal = 0.6;
	private static final int BrianDamageMin = 50;
	private static final int BrianDamageMax = 70;
	private static final int BrianMinHeal = 10;
	private static final int BrianMaxHeal = 50;
	
    public BrianTheCamp()
	{
    	super(BrianName, BrianHitPoints, BrianAttackSpeed, BrianChanceToHit,
    			BrianChanceToHeal, BrianDamageMin, BrianDamageMax, 
    			BrianMinHeal, BrianMaxHeal);
	}
	
}
