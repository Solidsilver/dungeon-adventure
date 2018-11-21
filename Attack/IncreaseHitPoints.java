package Attack;

import characters.DungeonCharacter;
import characters.heroes.Sorceress;

public class IncreaseHitPoints implements IAttack{

	public void action(DungeonCharacter character) 
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
