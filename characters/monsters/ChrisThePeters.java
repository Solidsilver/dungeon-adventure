package characters.monsters;

public class ChrisThePeters extends Monster{

	private static final String ChrisName = "Chris the Peters";
	private static final int ChrisHitPoints = 50;
	private static final int ChrisAttackSpeed = 4;
	private static final double ChrisChanceToHit = 0.3;
	private static final double ChrisChanceToHeal = 0.6;
	private static final int ChrisDamageMin = 20;
	private static final int ChrisDamageMax = 30;
	private static final int ChrisMinHeal = 60;
	private static final int ChrisMaxHeal = 70;
	
    public ChrisThePeters()
	{
		super(ChrisName, ChrisHitPoints, ChrisAttackSpeed, ChrisChanceToHit, 
				ChrisChanceToHeal, ChrisDamageMin, ChrisDamageMax, 
				ChrisMinHeal, ChrisMaxHeal);
		
	}
	
}
