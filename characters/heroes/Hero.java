package characters.heroes;

import characters.DungeonCharacter;

public abstract class Hero extends DungeonCharacter{

	protected double chanceToBlock;
	protected int numTurns;
	
	public Hero()
	{
		 super();
	}
	
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method
	
	abstract public void attack(DungeonCharacter character);
	abstract public void specialAttack(DungeonCharacter character);
	

}