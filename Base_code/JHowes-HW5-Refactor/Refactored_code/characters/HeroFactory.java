package characters;
import java.util.Scanner;

public class HeroFactory {

	public static Hero createHero() {
		
		int choice;		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");		
		if(input.hasNextInt())
	    	choice = input.nextInt();
	    else
	    	choice = 0;
		
		switch(choice)
		{
			case 1: return new Warrior();
			case 2: return new Sorceress();
			case 3: return new Thief();

			default: System.out.println("invalid choice, returning Thief");
				return new Thief();
		}
	}	
}
