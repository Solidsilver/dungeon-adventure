package base_code.mattfeldL-refactor.dungeon;
import java.util.Scanner;
import dungeon.characters.*;
import dungeon.characters.heroes.*;
import dungeon.characters.monsters.*;
/**
 * 
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * Authors: Eye M. Knurdy, Yew Artue, Sue Perg-Eek, Rein Bough, and Sauchfuhn.
 * 
 * 
 * Description: Driver file for Heroes and Monsters project. It will
 * do the following:
 * 	1.  Allow the user to choose a hero
 * 	2.  Randomly select a monster
 * 	3.  Allow the hero to battle the monster
 * Once a battle concludes, the user has the option of repeating the above.
 * 
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */

public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = chooseHero();
		    theMonster = generateMonster();
			battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
chooseHero allows the user to select a hero, creates that hero, and
returns it.  It utilizes a polymorphic reference (Hero) to accomplish
this task
---------------------------------------------------------------------*/
	public static Hero chooseHero()
	{
		HeroFactory hf = new HeroFactory();
		int choice;
		Hero theHero;
		Scanner kb = new Scanner(System.in);

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");

		choice = Integer.parseInt(kb.nextLine());
		//kb.close();

		switch(choice)
		{
			case 1: return hf.createHero("Warrior");

			case 2: return hf.createHero("Sorceress");

			case 3: return hf.createHero("Thief");

			default: System.out.println("invalid choice, returning Thief");
				     return hf.createHero("Thief");
		}//end switch
		
	}//end chooseHero method

/*-------------------------------------------------------------------
generateMonster randomly selects a Monster and returns it.  It utilizes
a polymorphic reference (Monster) to accomplish this task.
---------------------------------------------------------------------*/
	public static Monster generateMonster()
	{
		MonsterFactory mf = new MonsterFactory();
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return mf.createMonster("Ogre");

			case 2: return mf.createMonster("Gremlin");

			case 3: return mf.createMonster("Skeleton");

			default: System.out.println("invalid choice, returning Skeleton");
				     return mf.createMonster("Skeleton");
		}//end switch
	}//end generateMonster method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		Scanner kb = new Scanner(System.in);
		String again;

		System.out.println("Play again (y/n)?");
		again = kb.nextLine();
		
		//kb.close();
		return (again.toLowerCase().compareTo("y") == 0);
	}//end playAgain method


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{
		Scanner kb = new Scanner(System.in);
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			String p = kb.nextLine();
			if (!p.equals("")) {
				pause = p.charAt(0);
			}

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}//end Dungeon class