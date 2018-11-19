package characters.heroes;

public class Warrior extends Hero{

	private final String WarriorName = "Warrior";
	private final int WarriorHitPoints = 125;
	private final int WarriorAttackSpeed = 4;
	private final double WarriorChanceToHit = 0.8;
	private final int WarriorDamageMin = 35;
	private final int WarriorDamageMax = 60;
	private final double WarriorChanceToBlock = 0.2;
	
	HeroFactory fact;
	String specialAttack = "Crushing Blow";
	
	public Warrior()
	{

		super(/*"Warrior", 125, 4, .8, 35, 60, .2*/);
		this.name = WarriorName;
		this.hitPoints = WarriorHitPoints;
		this.attackSpeed = WarriorAttackSpeed;
		this.chanceToHit = WarriorChanceToHit;
		this.damageMin = WarriorDamageMin;
		this.damageMax = WarriorDamageMax;
		this.chanceToBlock = WarriorChanceToBlock;
		
		fact = new HeroFactory();

    }//end constructor
	
}
