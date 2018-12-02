package characters.monsters;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class Ogre extends Monster{

	private static final String OgreName = "Oscar the Ogre";
	private static final int OgreHitPoints = 200;
	private static final int OgreAttackSpeed = 2;
	private static final double OgreChanceToHit = 0.6;
	private static final double OgreChanceToHeal = 0.1;
	private static final int OgreDamageMin = 30;
	private static final int OgreDamageMax = 50;
	private static final int OgreMinHeal = 30;
	private static final int OgreMaxHeal = 50;
	
    public Ogre()
	{
		super(OgreName, OgreHitPoints, OgreAttackSpeed, OgreChanceToHit, OgreChanceToHeal,
				OgreDamageMin, OgreDamageMax, OgreMinHeal, OgreMaxHeal);
		
    }//end constructor
	
}
