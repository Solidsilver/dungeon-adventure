package characters.heroes;

import characters.DungeonCharacter;

public class Sorceress extends Hero{

	private final String SorceressName = "Sorceress";
	private final int SorceressHitPoints = 75;
	private final int SorceressAttackSpeed = 5;
	private final double SorceressChanceToHit = 0.7;
	private final int SorceressDamageMin = 25;
	private final int SorceressDamageMax = 50;
	private final double SorceressChanceToBlock = 0.3;
	
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	HeroFactory fact;
	String specialAttack = "Increase Hit Points";
	
    public Sorceress()
	{
		super();
		this.name = SorceressName;
		this.hitPoints = SorceressHitPoints;
		this.attackSpeed = SorceressAttackSpeed;
		this.chanceToHit = SorceressChanceToHit;
		this.damageMin = SorceressDamageMin;
		this.damageMax = SorceressDamageMax;
		this.chanceToBlock = SorceressChanceToBlock;
		
		fact = new HeroFactory();

    }//end constructor
    
    public void attack(DungeonCharacter character, int min, int max)
    {
    	
    }
    
    public void specialAttack(DungeonCharacter character, int min, int max)
    {
    	int hp = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
    	this.hitPoints += hp;
 		System.out.println(name + " added [" + hp + "] points.\n"
 							+ "Total hit points remaining are: "
 							+ this.hitPoints);
 		 System.out.println();
    }
    
	
}
