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


public class Warrior extends Hero
{

    protected Warrior()
	{
		super("Warrior", 125, 4, .8, 35, 60, .2);

    }//end constructor


    protected void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(this.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(this.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(this.getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice = 0;
		super.battleChoices(opponent);

		do
		{
			choice = usersBattleSelection();			
			performAttack( opponent, choice);	

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method

    
       
       private void performAttack(DungeonCharacter opponent, int choice) {
    	   switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: crushingBlow(opponent);
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
	    System.out.println("2. Crushing Blow on Opponent");
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
				    System.out.println("2. Crushing Blow on Opponent");
				    System.out.print("Choose an option: ");					  
		    	
	    	}while(!validChoice);
	    	System.out.println("");
   		 return choice;
       }
}//end Hero class