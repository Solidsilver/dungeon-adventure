package characters.monsters;

public class Ogre extends Monster{

	private final String OgreName = "Oscar the Ogre";
	private final int OgreHitPoints = 200;
	private final int OgreAttackSpeed = 2;
	private final double OgreChanceToHit = 0.6;
	private final double OgreChanceToHeal = 0.1;
	private final int OgreDamageMin = 30;
	private final int OgreDamageMax = 50;
	private final int OgreMinHeal = 30;
	private final int OgreMaxHeal = 50;
	
    public Ogre()
	{
		super();
		this.name = OgreName;
		this.hitPoints = OgreHitPoints;
		this.attackSpeed = OgreAttackSpeed;
		this.chanceToHit = OgreChanceToHit;
		this.chanceToHeal = OgreChanceToHeal;
		this.damageMin = OgreDamageMin;
		this.damageMax = OgreDamageMax;
		this.minHeal = OgreMinHeal;
		this.maxHeal = OgreMaxHeal;

    }//end constructor
	
}
