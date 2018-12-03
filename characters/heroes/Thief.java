package characters.heroes;

/**
 * @author Andrew Sales
 */

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
