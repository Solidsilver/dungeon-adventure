package characters;
import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;

//-----------------------------------------------------------------
	protected Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3);


    }//end constructor

//-----------------------------------------------------------------
	protected void increaseHitPoints()
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(this.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ this.getHitPoints());
		 System.out.println();

    }//end increaseHitPoints method

//-----------------------------------------------------------------
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

//-----------------------------------------------------------------
    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice = 0;

		do
		{
			choice = usersBattleSelection();			
			performAttack(opponent, choice);			    

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0 && this.getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method
    
    private void performAttack(DungeonCharacter opponent, int choice) {
    	switch (choice)
	    {
		    case 1: attack(opponent);
		        break;
		    case 2: increaseHitPoints();
		        break;
		    default:
		        System.out.println("invalid choice!");
	    }//end switch
    }
    
    private int usersBattleSelection() {
    	int choice = 0;
    	
    	Scanner input = new Scanner(System.in);
		boolean validChoice; 
		
	    System.out.println("1. Attack Opponent");
	    System.out.println("2. Increase Hit Points");
	    System.out.print("Choose an option: ");
	    
	    do {
		    if(input.hasNextInt() ) {
		    	choice = input.nextInt();
		    	
		    }
		    if(choice == 1 || choice == 2) {
		    	
		    	validChoice = true;			    
		    	break;
		    }
		    else
		    	validChoice = false;
		    	
		    		input.next();			    		
					System.out.println("invalid choice!\n");
					System.out.println("1. Attack Opponent");
				    System.out.println("2. Increase Hit Points");
				    System.out.print("Choose an option: ");					  
		    	
	    }while(!validChoice);
	    System.out.println("");
	  return choice;
    }

}//end class