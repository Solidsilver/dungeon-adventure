package characters.monsters;
import characters.DungeonCharacter;

public abstract class Monster extends DungeonCharacter{

	protected double chanceToHeal;
	protected int minHeal, maxHeal;
	
	public Monster()
	{
		super();
	}//end monster constructor

	
	
}