package base_code.JHowes-HW5-Refactor.Refactored_code;
/**
 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
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



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/

import java.util.Scanner;
import characters.*;

public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;
				
		do
		{
			//Initialize the game
		    theHero = HeroFactory.createHero();
		    theMonster = MonsterFactory.createMonster();
		    
		    startGame(theHero, theMonster);
		    
		    do 
		    {
		    	battle(theHero, theMonster);
		    }
		    while(!EndOfGame (theHero, theMonster) );		   
		    		    
			printWinner(theHero, theMonster);

		} while (playAgain() );
    }//end main method

  

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	private static boolean playAgain()
	{
		char again;
		Scanner input = new Scanner(System.in);

		System.out.println("Play again (y/n)?");
		again = input.nextLine().charAt(0);

		return (again == 'Y' || again == 'y');
	}//end playAgain method


	private static void startGame(Hero theHero, Monster theMonster) {
		System.out.println("");
		System.out.println(theHero.getName() + " battles " + theMonster.getName());
	    System.out.println("---------------------------------------------");
	}
	
/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	private static void battle(Hero theHero, Monster theMonster)
	{	
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

	}//end battle method

	private static boolean EndOfGame(Hero theHero, Monster theMonster) {
		
		Scanner input = new Scanner(System.in);
		String KeyboardInput;
		char pause = 'p';	
		System.out.println("-->q to quit, anything else to continue: ");
		
		try 
		{			
			if(input.hasNext()) 
			{
				if(input.hasNextInt())
				{					
					pause = String.valueOf(input.nextInt()).charAt(0);					
				}
				
				else 
				{					
					KeyboardInput = input.nextLine();
					pause = KeyboardInput.charAt(0);	
				}					
			}

		}//end try
		catch(Exception e)
		{			
			pause = 'A';
		}
		
		System.out.println("");
		
		return (!(theHero.isAlive() && theMonster.isAlive() && pause != 'q'));
	}

	private static void printWinner(Hero theHero, Monster theMonster) {
		
		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");
	}

}//end Dungeon class