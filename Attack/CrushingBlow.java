package Attack;

import java.io.Serializable;

import characters.DungeonCharacter;

public class CrushingBlow implements IAttack, Serializable{
	
	public void action(DungeonCharacter character, DungeonCharacter opponent) 
	{	
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * character.getDamageMax() + 25) + 100;
			System.out.println(character.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(character.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed
	}

}
