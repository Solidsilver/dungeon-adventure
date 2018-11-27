package characters;
import java.io.Serializable;
/**
 * Description: Abstract Base class for inheritance hierarchy for characters
*/

public abstract class DungeonCharacter implements Serializable
{

	protected String characterName;
	protected int healthPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin, damageMax;

	//EVC
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax)
	{

		this.characterName = name;
		this.healthPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;

	}//end constructor

	public String getName()
	{
		return characterName;
	}//end getName

	protected void setName(String name) {
		if (name != null) {
			this.characterName = name;
		}
	}

	public int getHealthPoints()
	{
		return healthPoints;
	}//end getHitPoints

	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed


	public void inflictDamage(int hitPoints) {
		subtractHitPoints(hitPoints);
	}

	private void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.healthPoints += hitPoints;

		}
	}//end addHitPoints method


	private void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.healthPoints -= hitPoints;
			if (this.healthPoints < 0)
				this.healthPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHealthPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.healthPoints == 0)
			System.out.println(characterName + " has been killed :-(");


	}//end method


    public boolean isAlive()
	{
	  return (healthPoints > 0);
	}//end isAlive method


	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (damageMax - damageMin + 1))+ damageMin ;
			opponent.inflictDamage(damage);
			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

}//end class Character