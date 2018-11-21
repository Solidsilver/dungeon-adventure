package characters.heroes;

import java.util.ArrayList;
import characters.DungeonCharacter;
import pickups.PickupItem;

public abstract class Hero extends DungeonCharacter{

	protected double chanceToBlock;
	protected int numTurns;
	ArrayList<PickupItem> inventory;
	int numPillars = 0, numHealPotions = 0, numVisPotions = 0;
	
	public Hero(String name, int hitPoints, int attackSpeed,
		     double chanceToHit, int damageMin, int damageMax,
			 double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
	}
	
	
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method
	
	public ArrayList<PickupItem> getInventory() {return inventory;}
	public void addToInventory(ArrayList<PickupItem> items)
	{
		for(int i = 0; i < items.size(); i++)
		{
			//items[i].toString();
		}
	}
	
	public void useItem()
	{
		
	}
	
	//get inventory method, returns arraylist of strings
	//use item function

}