package characters.heroes;

/**
 * @author Andrew Sales
 */

public class StuTheSteiner extends Hero{

	private static final String StuName = "Stu the Steiner";
	private static final int StuHitPoints = 10;
	private static final int StuAttackSpeed = 2;
	private static final double StuChanceToHit = 0.1;
	private static final int StuDamageMin = 10;
	private static final int StuDamageMax = 20;
	private static final double StuChanceToBlock = 0.1;
	
	private final int MIN_ADD = 40;
	private final int MAX_ADD = 70;
	
	public StuTheSteiner()
	{
		super(StuName, StuHitPoints, StuAttackSpeed, StuChanceToHit, StuDamageMin,
				StuDamageMax, StuChanceToBlock, "Surprise Attack");
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
