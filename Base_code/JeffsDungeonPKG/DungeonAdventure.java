package base_code.JeffsDungeonPKG;

import java.util.Scanner;

public class DungeonAdventure {
	
	private static boolean GameFinished = false;
	
	
	public static void main(String[] args) {
		char playersChoice;
		Dungeon myDungeon = new Dungeon(); // initialize the dungeon
		Hero myHero = new Hero();			// initialize the hero
		myHero.setDungeonRef(myDungeon); //pass the dungeons ref to the Hero, so it can access items in the rooms.
		 
		
		//move hero to starting location
		myHero.setHerosYCoord(myDungeon.getEntranceLocation() / myDungeon.getMAPSMAX_X() );
		myHero.setHerosXCoord(myDungeon.getEntranceLocation() % myDungeon.getMAPSMAX_X() );
		myDungeon.setHeorsYLocation(myDungeon.getEntranceLocation() / myDungeon.getMAPSMAX_X() );
		myDungeon.setHeorsXLocation(myDungeon.getEntranceLocation() % myDungeon.getMAPSMAX_X() );
		//System.out.println(myDungeon);
		
		//game main loop, go until the GameFinished field is true
		
		welcomeMenu();		
		do
		{
			System.out.println(myHero); // prints hero's stats
			System.out.println(myDungeon.getCurrentRoom() );
			playersChoice = menuOptions();  //return the char of the choice.
			System.out.println("\n"); 
			actOnHerosChoice(playersChoice, myHero, myDungeon);
			System.out.println("\n"); 
		}
		while(!isGameFinished(myHero, myDungeon) && myHero.getHitPoints() >0 );
		
		if(myHero.getHitPoints() == 0) {
			System.out.println("\n*******************************************");
			System.out.println("****************YOU WON!!!*****************");
			System.out.println("*******************************************\n");
			System.out.println("Thanks for playing Heros Quest! Here are your final stats");
			System.out.println(myHero);
			System.out.println("Exiting the game.");
		}
		else
			System.out.println("\n*******************************************");
			System.out.println("****************YOU LOST!!!*****************");
			System.out.println("*******************************************\n");
			System.out.println("Thanks for playing Heros Quest! Here are your final stats");
			System.out.println(myHero);
			System.out.println("Exiting the game.");
		
		//act on the choice.  switch statement.  Moves are validated. if invalid print it, break out, so the main game loop starts again.
		// if the choice is valid, call appropriate methods, so actions happen.
		// check to see if the game is finished.

					
		
					
								
					//************************************************************************************
					/*  testing out the isNextMoveValid method. 
					 * //Testing the move hero method
					myHero.setHerosYCoord(2 );
					myHero.setHerosXCoord(2 );
					myDungeon.setHeorsYLocation(2 );
					myDungeon.setHeorsXLocation(2 );
					System.out.println("setting location to 2,2");
					System.out.println(myDungeon);
					
					//System.out.println("DEBUG  --- printing myHero.getHerosXCoord() " + myHero.getHerosXCoord() + "; printing myHero.getHerosYCoord() " + myHero.getHerosYCoord() );
					//System.out.println("DEBUG  --- printing myDungeon.getHerosXLocation() " + myDungeon.getHerosXLocation() + "; printing myDungeon.getHerosYLocation() " + myDungeon.getHerosYLocation() );
					
					//System.out.println("moving hero north");		
					//myHero.moveHero('N');		
					//System.out.println(myDungeon);
					
					
					System.out.println("Is moving to the north valid: " + myDungeon.isNextMoveValid('N') );
					System.out.println("Is moving to the south valid: " + myDungeon.isNextMoveValid('S') );
					System.out.println("Is moving to the west valid: " + myDungeon.isNextMoveValid('W') );
					System.out.println("Is moving to the east valid: " + myDungeon.isNextMoveValid('E') );
					*/
					
					//System.out.println(menuOptions(myHero, myDungeon) + " is the menu option you picked.");		
					
	}
	
	public static void welcomeMenu(){
		System.out.println("Welcome ... here are the insturctions ...");
	}
	
	/**
	 * 
	 *set to true only when hero has found both pieces and current location isExit.
	 * @param myHero
	 * @param myDungeon
	 * @return
	 */
	public static boolean isGameFinished(Hero myHero, Dungeon myDungeon) {
				
		if(myHero.hasFoundBothCrownPeices() && myDungeon.getCurrentRoom().isExit() )
			return true;
		else 
			return false;
	}
	
		
	public static void actOnHerosChoice(char choice, Hero myHero, Dungeon myDungeon) {
		switch (choice) 
		{
		case 'N':	
			if(myDungeon.isNextMoveValid('N') ) 					
				myHero.moveHero('N');
			else 
				System.out.println("Invalid direction.");			
			break;
		case 'S':				
			if(myDungeon.isNextMoveValid('S') ) 					
				myHero.moveHero('S');
			else 
				System.out.println("Invalid direction.");			
			break;
		case 'W':				
			if(myDungeon.isNextMoveValid('W') ) 					
				myHero.moveHero('W');
			else 
				System.out.println("Invalid direction.");			
			break;
		case 'E':				
			if(myDungeon.isNextMoveValid('E') ) 					
				myHero.moveHero('E');
			else 
				System.out.println("Invalid direction.");			
			break;
		case 'H':
			if(myHero.getHealingPotionCount() >=1)
				myHero.useHealingPotion();
			else
				System.out.println("You don't have a healing potion in your inventory!");
			break;
		case 'V':				
			if(myHero.getVisionPotionCount() >=1)
				System.out.println("Vision potion feature not implement!");
			else
				System.out.println("You don't have a vision potion in your inventory!");
			break;
		case 'M':				
			System.out.println("Printing entire map");
			System.out.println(myDungeon);
			break;
		case 'L':				
			System.out.println("Adding 1,000 hit points to Hero");
			myHero.setHitPoints(1000);
			break;
		case 'Q':				
			System.out.println("Thanks for playing Heros Quest! (Quiter!!!!)  Here are your final stats");
			System.out.println(myHero);
			System.out.println("Exiting the game.");
			System.exit(0);
			break;
		default:
			
			break;
		}//end switch					
	}
	
	public static char menuOptions() {
		char usersChoice;
		boolean validChoice = false; 
		
		do
		{
			Scanner keyboard = new Scanner(System.in);
			char[] menuOptionsLetters = {'N', 'S', 'E', 'W', 'H', 'V','M', 'L', 'Q'};
			
			System.out.println("\nN, W, E, or S - to move the Hero in that direction");			
			System.out.println("H - use a healing potion");
			System.out.println("V - use a vision potion");
			System.out.println("M - (Hidden command) display entire map");
			System.out.println("L - (Hidden command) Add 1,000 hit point to hero.");
			System.out.println("Q - to Quit.");
			
			keyboard = new Scanner(System.in);
			String UC = keyboard.nextLine();
			usersChoice = UC.charAt(0);
			
			
			for (char L : menuOptionsLetters) {
				if(L == usersChoice) {
					validChoice = true; 
					//System.out.println("That letter is valid");
					break;
				}//end if
			}//end for loop
			if(validChoice == false)
				System.out.println("Invalid menu option, please try again");
		}
		while(!validChoice);
		
		return usersChoice;
	}//end method menuOptions
	
	/** old menuOptions method
	public static char menuOptions(Hero myHero, Dungeon myDungeon) {
		String choice;
		boolean isValidMenuOption = false;
		boolean isValidMove = true;
		Scanner keyboard = new Scanner(System.in);
				
		do
		{
			System.out.println("\nEnter a direction to move: N, W, E, S");			
			System.out.println("Select H to use a healing potion or  V to use a Vision potion");
			System.out.println("M - (Hidden command) display entire map");
			System.out.println("L - (Hidden command) Add 1,000 hit point to hero.");
			
			keyboard = new Scanner(System.in);
			choice = keyboard.nextLine();
			
			switch (choice.charAt(0)) 
			{
			case 'N':				
				isValidMenuOption = true;		
				if(myDungeon.isNextMoveValid('N') ) 					
					isValidMove = true;
				else {
					System.out.println("Invalid direction, please select again.");
					isValidMove = false;
				}
				break;
			case 'S':				
				isValidMenuOption = true;
				isValidMove = myDungeon.isNextMoveValid('S');
				System.out.println("Invalid direction, please select again.");
				break;
			case 'W':				
				isValidMenuOption = true;
				isValidMove = myDungeon.isNextMoveValid('W');
				System.out.println("Invalid direction, please select again.");
				break;
			case 'E':				
				isValidMenuOption = true;
				isValidMove = myDungeon.isNextMoveValid('E');
				System.out.println("Invalid direction, please select again.");
				break;
			case 'H':				
				isValidMenuOption = true;
				if(myHero.getHealingPotionCount() >=1)
					
				break;
			case 'V':				
				isValidMenuOption = true;
				break;
			case 'M':				
				isValidMenuOption = true;
				System.out.println(myDungeon);
				break;
			case 'L':				
				isValidMenuOption = true;
				myHero.setHitPoints(1000);
				break;
			default:
				isValidMenuOption = false;
				System.out.println("Invalid menu option, please select again.");
				break;
			}//end switch					
		} 
		while(!isValidMenuOption && !isValidMove);// end while
		
		
		return choice.charAt(0);		
	
	}//end menuOptions
	*/

}//end class
