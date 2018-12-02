package characters.heroes;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class Sorceress extends Hero {

	private static final String SorceressName = "Sorceress";
	private static final int SorceressHitPoints = 75;
	private static final int SorceressAttackSpeed = 5;
	private static final double SorceressChanceToHit = 0.7;
	private static final int SorceressDamageMin = 25;
	private static final int SorceressDamageMax = 50;
	private static final double SorceressChanceToBlock = 0.3;
	
	private final int MIN_ADD = 25;
	private final int MAX_ADD = 50;
	
    public Sorceress()
	{
		super(SorceressName, SorceressHitPoints, SorceressAttackSpeed, SorceressChanceToHit,
				SorceressDamageMin, SorceressDamageMax, SorceressChanceToBlock, 
				"Increase Hit Points");
    }//end constructor
    
    public int getMinAdd()
    {
    	return MIN_ADD;
    }
    
    public int getMaxAdd()
    {
    	return MAX_ADD;
    }
    

   
}
