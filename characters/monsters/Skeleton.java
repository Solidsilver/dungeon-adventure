package characters.monsters;

public class Skeleton extends Monster{

	private final String SkeletonName = "Sargath the Skeleton";
	private final int SkeletonHitPoints = 100;
	private final int SkeletonAttackSpeed = 3;
	private final double SkeletonChanceToHit = 0.8;
	private final double SkeletonChanceToHeal = 0.3;
	private final int SkeletonDamageMin = 30;
	private final int SkeletonDamageMax = 50;
	private final int SkeletonMinHeal = 30;
	private final int SkeletonMaxHeal = 50;
	
    public Skeleton()
	{
		super(/*"Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50*/);
		this.name = SkeletonName;
		this.hitPoints = SkeletonHitPoints;
		this.attackSpeed = SkeletonAttackSpeed;
		this.chanceToHit = SkeletonChanceToHit;
		this.chanceToHeal = SkeletonChanceToHeal;
		this.damageMin = SkeletonDamageMin;
		this.damageMax = SkeletonDamageMax;
		this.minHeal = SkeletonMinHeal;
		this.maxHeal = SkeletonMaxHeal;

    }//end constructor
	
}
