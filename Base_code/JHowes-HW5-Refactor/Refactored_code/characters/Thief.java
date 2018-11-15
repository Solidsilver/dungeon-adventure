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

public class Thief extends Hero
{

	protected Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);
    }//end constructor

	protected void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								this.getName() + " gets an additional turn.");
			numTurns++;
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice = 0;

		do
		{
			choice = usersBattleSelection();			
			performAttack( opponent, choice);			
			
			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }// end of battleChoices 
    
    private void performAttack(DungeonCharacter opponent, int choice) {
    	switch (choice)
	    {
		    case 1: attack(opponent);
		        break;
		    case 2: surpriseAttack(opponent);
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
		    System.out.println("2. Surprise Attack");
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
					    System.out.println("2. Surprise Attack");
					    System.out.print("Choose an option: ");					  
			    	
		    }while(!validChoice);
		    System.out.println("");
		 return choice;
    }

    
}//end of class