package characters.heroes;

<<<<<<< HEAD
import characters.DungeonCharacter;
=======
import java.util.ArrayList;

import Attack.IAttack;
import characters.DungeonCharacter;
import pickups.PickupItem;

public abstract class Hero extends DungeonCharacter{

	protected double chanceToBlock;
	protected int numTurns;
	
	ArrayList<PickupItem> inventory;
	int numPillars;
	int numHealingPotions;
	int numVisionPotions;
	protected String specialAttack;
	
	public Hero(String name, int hitPoints, int attackSpeed,
		     double chanceToHit, int damageMin, int damageMax,
			 double chanceToBlock, String specialAttack)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.specialAttack = specialAttack;
		numPillars = 0;
		numHealingPotions = 0;
		numVisionPotions = 0;
	}
	
	public void specialAction(DungeonCharacter opponent)
    {
    	IAttack tack = fact.getAttack(specialAttack);
		tack.action(this, opponent);
    }
	
	public boolean hasAllPillars()
	{
		return numPillars == 4;
	}
	
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method
	
	public ArrayList<PickupItem> getInventory() {return inventory;}
	
	public String printInventory()
	{
		String myInventory = "Player inventory:\n";
		
		for(int i = 0; i < inventory.size(); i++)
		{
			myInventory += inventory.get(i).toString() + "\n";
		}
		
		return myInventory;
	}
	
	public void addToInventory(ArrayList<PickupItem> items)
	{		
		if(items.get(0).getName() == "Pillar")
			numPillars++;
		for(int i = 0; i < items.size(); i++)
		{
			inventory.add(items.get(i));
		}
	}
	
	public PickupItem useItem(int index)
	{
		//return inventory[index].
		return null;
	}
	
	public void setName(String newName)
	{
		this.name = newName + " the " + name;
	}
	
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices
	
	public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}

	}//end method
	
	public int getNumTurns()
	{
		return numTurns;
	}
	
	public void setNumTurns(int amount)
	{
		this.numTurns += amount;
	}
	
	//get inventory method, returns arraylist of strings
	//use item function
>>>>>>> DAcharacter

import java.util.Scanner;
import pickups.*;
import java.util.ArrayList;

public abstract class Hero extends DungeonCharacter {
	private static final long serialVersionUID = 1L;
	protected String specialActionName;
	protected double chanceToBlock;
	protected int numTurns;
	protected ArrayList<PickupItem> inventory;

	// -----------------------------------------------------------------
	// calls base constructor and gets name of hero from user
	Hero(String name, String special, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		//System.out.println("Assigning special: " + special);
		this.specialActionName = special;
		readName();
		this.inventory = new ArrayList<>();
	}

	public void readName() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter character name: ");
		super.setName(kb.nextLine());
	}// end readName method

	public void addToInventory(PickupItem p) {
		this.inventory.add(p);
	}

	public void addToInventory(ArrayList<PickupItem> plist) {
		this.inventory.addAll(plist);
	}

	public void useInventoryItem(int index) {
		this.inventory.get(index).use();
	}

	public ArrayList<String> inventoryToString() {
		ArrayList<String> invStr = new ArrayList<>();
		for (PickupItem p: this.inventory) {
			invStr.add(p.toString());
		}
		return invStr;
	}
	
	public boolean defend() {
		return Math.random() <= chanceToBlock;

	}// end defend method

	public abstract void specialAction(DungeonCharacter opponent);

	@Override
	public void inflictDamage(int hitPoints) {
		if (defend()) {
			System.out.println(characterName + " BLOCKED the attack!");
		} else {
			super.inflictDamage(hitPoints);
		}
	}

	
	public void battleChoices(DungeonCharacter opponent) {
		numTurns = attackSpeed / opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

		int choice;

		Scanner kb = new Scanner(System.in);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. " + specialActionName);
		    System.out.print("Choose an option: ");
		    choice = Integer.parseInt(kb.nextLine());

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: specialAction(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

	}// end battleChoices

	public String getName() {
		return super.getName();
	}

}// end Hero class