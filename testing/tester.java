import characters.DungeonCharacter;
import characters.heroes.Hero;
import characters.heroes.TomTheCapaul;
import characters.monsters.Gremlin;
import characters.monsters.Monster;

public class tester {

	 public static void main(String[] args)
	{
		Hero mycharacter = new TomTheCapaul(); 
		Monster enemy = new Gremlin();
		
		/*while(mycharacter.isAlive() && enemy.isAlive()) 
		{
			mycharacter.attack(enemy);
			
		}
		while(mycharacter.isAlive() && enemy.isAlive()) 
		{
			
			enemy.attack(mycharacter);
		}*/
		
		
		while(mycharacter.isAlive() && enemy.isAlive()) 
		{
			mycharacter.specialAction(enemy);
			
		}
		while(mycharacter.isAlive() && enemy.isAlive()) 
		{
			
			enemy.attack(mycharacter);
		}
		
	}
	
}
