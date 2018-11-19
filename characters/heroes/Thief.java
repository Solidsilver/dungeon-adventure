package characters.heroes;

public class Thief extends Hero{

	private final String ThiefName = "Thief";
	private final int ThiefHitPoints = 75;
	private final int ThiefAttackSpeed = 6;
	private final double ThiefChanceToHit = 0.8;
	private final int ThiefDamageMin = 20;
	private final int ThiefDamageMax = 40;
	private final double ThiefChanceToBlock = 0.5;

	HeroFactory fact;
	String specialAttack = "Surprise Attack";
	
	public Thief()
	{
		super();
		this.name = ThiefName;
		this.hitPoints = ThiefHitPoints;
		this.attackSpeed = ThiefAttackSpeed;
		this.chanceToHit = ThiefChanceToHit;
		this.damageMin = ThiefDamageMin;
		this.damageMax = ThiefDamageMax;
		this.chanceToBlock = ThiefChanceToBlock;

		fact = new HeroFactory();
		
    }//end constructor
	
}
