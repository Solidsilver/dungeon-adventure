package characters.heroes;

public class StuTheSteiner extends Hero{

	private final String StuName = "Stu the Steiner";
	private final int StuHitPoints = 10;
	private final int StuAttackSpeed = 2;
	private final double StuChanceToHit = 0.1;
	private final int StuDamageMin = 10;
	private final int StuDamageMax = 20;
	private final double StuChanceToBlock = 0.1;

	HeroFactory fact;
	String specialAttack = "Increase Hit Points";
	
	public StuTheSteiner()
	{
		super();
		this.name = StuName;
		this.hitPoints = StuHitPoints;
		this.attackSpeed = StuAttackSpeed;
		this.chanceToHit = StuChanceToHit;
		this.damageMin = StuDamageMin;
		this.damageMax = StuDamageMax;
		this.chanceToBlock = StuChanceToBlock;

		fact = new HeroFactory();
		
    }//end constructor
	
}
