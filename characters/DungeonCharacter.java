package characters;
import java.io.Serializable;
import dungeon.Dungeon;
/**
 * Description: Abstract Base class for inheritance hierarchy for characters
*/

import Attack.AttackFactory;
import Attack.IAttack;
import characters.heroes.HeroFactory;

/**
 * @author Andrew Sales
 */

public abstract class DungeonCharacter implements Serializable {

	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin;
	protected int damageMax;
	
	protected AttackFactory fact;
	
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
		     double chanceToHit, int damageMin, int damageMax)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		
		fact = new AttackFactory();
	}
	
	public String getName()
	{
		return name;
	}//end getName
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHitPoints(int points)
	{
		this.hitPoints += points;
	}
	
	public int getHitPoints()
	{
		return hitPoints;
	}//end getHitPoints
	
	public int getAttackSpeed()
	{
		return attackSpeed;
	}//end getAttackSpeed
	
	public int getDamageMin()
	{
		return damageMin;
	}
	
	public int getDamageMax()
	{
		return damageMax;
	}
	
	public double getChanceToHit()
	{
		return chanceToHit;
	}

	public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		else if (hitPoints >0)
		{
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.println(getName() + " hit " +
								" for <" + hitPoints + "> points damage.");
			System.out.println(getName() + " now has " +
								getHitPoints() + " hit points remaining.");
			System.out.println();
		}//end else if

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");

	}//end method
	
	public void attack(DungeonCharacter opponent)
	{
		IAttack tack = fact.getAttack("Attack");
		tack.action(this, opponent);
	}
	
	public boolean isAlive()
	{
	  return (hitPoints > 0);
	}//end isAlive method
	
	
	
}
