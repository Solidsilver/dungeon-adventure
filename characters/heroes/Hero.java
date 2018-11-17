package characters.heroes;

import characters.DungeonCharacter;
import java.util.Scanner;

public abstract class Hero extends DungeonCharacter {
	protected String specialActionName;
	protected double chanceToBlock;
	protected int numTurns;

	// -----------------------------------------------------------------
	// calls base constructor and gets name of hero from user
	Hero(String name, String special, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock) {
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		//System.out.println("Assigning special: " + special);
		this.specialActionName = special;
		readName();
	}

	public void readName() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter character name: ");
		super.setName(kb.nextLine());
	}// end readName method

	
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