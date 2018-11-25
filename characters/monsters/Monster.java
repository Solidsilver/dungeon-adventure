package characters.monsters;
import characters.DungeonCharacter;

public abstract class Monster extends DungeonCharacter{

	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	
	public Monster(String name, int hitPoints, int attackSpeed,
		     double chanceToHit, double chanceToHeal,
			 int damageMin, int damageMax,
			 int minHeal, int maxHeal)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
	
	}//end monster constructor

	public void heal()
	  {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

		if (canHeal)
		{
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			this.addHitPoints(healPoints);
			System.out.println(name + " healed itself for " + healPoints + " points.\n"
								+ "Total hit points remaining are: " + hitPoints);
			System.out.println();
		}//end can heal


	  }//end heal method
	
	public void subtractHitPoints(int hitPoints)
	 {
			super.subtractHitPoints(hitPoints);
			heal();

	 }//end method
	
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;
			//System.out.println("Remaining Hit Points: " + hitPoints);

		}
	}//end addHitPoints method
	
}