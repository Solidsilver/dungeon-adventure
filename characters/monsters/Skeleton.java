package characters.monsters;

/**
 * @author Andrew Sales
 */

public class Skeleton extends Monster{

	private static final String SkeletonName = "Sargath the Skeleton";
	private static final int SkeletonHitPoints = 100;
	private static final int SkeletonAttackSpeed = 3;
	private static final double SkeletonChanceToHit = 0.8;
	private static final double SkeletonChanceToHeal = 0.3;
	private static final int SkeletonDamageMin = 30;
	private static final int SkeletonDamageMax = 50;
	private static final int SkeletonMinHeal = 30;
	private static final int SkeletonMaxHeal = 50;
	
    public Skeleton()
	{
		super(SkeletonName, SkeletonHitPoints, SkeletonAttackSpeed, SkeletonChanceToHit, 
				SkeletonChanceToHeal, SkeletonDamageMin, SkeletonDamageMax, 
				SkeletonMinHeal, SkeletonMaxHeal);
		

    }//end constructor
	
}
