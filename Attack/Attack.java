package Attack;

import java.io.Serializable;

/**
 * @author Andrew Sales
 */

import characters.DungeonCharacter;

public class Attack implements IAttack, Serializable{

	public void action(DungeonCharacter character, DungeonCharacter opponent) 
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= opponent.getChanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (opponent.getDamageMax() - opponent.getDamageMin() + 1)) 
					+ opponent.getDamageMin() ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		}//end if can attack
		else
		{
			System.out.println(character.getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}//end else
	}

}
