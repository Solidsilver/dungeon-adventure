package characters.heroes;

public class TomTheCapaul extends Hero{

	private final String TomName = "Tom the Capaul";
	private final int TomHitPoints = 100;
	private final int TomAttackSpeed = 10;
	private final double TomChanceToHit = 1;
	private final int TomDamageMin = 100;
	private final int TomDamageMax = 100;
	private final double TomChanceToBlock = 1;
	
	HeroFactory fact;
	String specialAttack = "Crushing Blow";

	public TomTheCapaul()
	{
		super();
		this.name = TomName;
		this.hitPoints = TomHitPoints;
		this.attackSpeed = TomAttackSpeed;
		this.chanceToHit = TomChanceToHit;
		this.damageMin = TomDamageMin;
		this.damageMax = TomDamageMax;
		this.chanceToBlock = TomChanceToBlock;

		fact = new HeroFactory();
		
    }//end constructor
	
}
