package characters.heroes;

import java.io.Serializable;
import java.util.ArrayList;

import Attack.IAttack;
import characters.DungeonCharacter;
import pickups.PickupItem;

public abstract class Hero extends DungeonCharacter implements Serializable {

	protected double chanceToBlock;
	protected int numTurns;

	ArrayList<PickupItem> inventory;
	int numPillars;
	int numHealingPotions;
	int numVisionPotions;
	protected String specialAttack;

	public Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, String specialAttack) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.specialAttack = specialAttack;
		numPillars = 0;
		numHealingPotions = 0;
		numVisionPotions = 0;
		this.inventory = new ArrayList<>();
	}

	public void specialAction(DungeonCharacter opponent) {
		IAttack tack = fact.getAttack(specialAttack);
		tack.action(this, opponent);
	}

	public boolean hasAllPillars() {
		return numPillars == 4;
	}

	public boolean defend() {
		return Math.random() <= chanceToBlock;

	}// end defend method

	public ArrayList<PickupItem> getInventory() {
		return inventory;
	}

	public ArrayList<String> inventoryToString() {
		ArrayList<String> ret = new ArrayList<>();
		for (PickupItem itm : this.inventory) {
			ret.add(itm.getName());
		}
		return ret;
	}

	public String printInventory() {
		String myInventory = "Player inventory:\n";

		for (int i = 0; i < inventory.size(); i++) {
			myInventory += inventory.get(i).toString() + "\n";
		}

		return myInventory;
	}

	public void addToInventory(ArrayList<PickupItem> items) {
		if (items != null) {
			if (items.get(0).getName() == "Pillar")
				numPillars++;
			this.inventory.addAll(items);
			/*
			 * for(int i = 0; i < items.size(); i++) { inventory.add(items.get(i)); }
			 */
		}

	}

	public PickupItem useItem(int index) {
		// return inventory[index].
		return null;
	}

	public void setName(String newName) {
		this.name = newName + " the " + name;
	}

	public void battleChoices(DungeonCharacter opponent) {
		numTurns = attackSpeed / opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}// end battleChoices

	public void subtractHitPoints(int hitPoints) {
		if (defend()) {
			System.out.println(name + " BLOCKED the attack!");
		} else {
			super.subtractHitPoints(hitPoints);
		}

	}// end method

	public int getNumTurns() {
		return numTurns;
	}

	public void setNumTurns(int amount) {
		this.numTurns += amount;
	}

	// get inventory method, returns arraylist of strings
	// use item function
}
