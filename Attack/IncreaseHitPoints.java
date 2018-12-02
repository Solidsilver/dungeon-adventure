package Attack;

import java.io.Serializable;

import characters.DungeonCharacter;
import characters.heroes.Sorceress;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class IncreaseHitPoints implements IAttack, Serializable{

	public void action(DungeonCharacter character, DungeonCharacter opponent) 
	{	
		int hPoints;
		Sorceress yourself = (Sorceress)character;

		hPoints = (int)(Math.random() * (yourself.getMaxAdd() - yourself.getMinAdd() + 1)) + yourself.getMinAdd();
		character.setHitPoints(hPoints);
		System.out.println(character.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ character.getHitPoints());
		System.out.println();
	}

}
