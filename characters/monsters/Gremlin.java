package characters.monsters;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public class Gremlin extends Monster{

	private static final String GremlinName = "Gnarltooth the Gremlin";
	private static final int GremlinHitPoints = 70;
	private static final int GremlinAttackSpeed = 5;
	private static final double GremlinChanceToHit = 0.8;
	private static final double GremlinChanceToHeal = 0.4;
	private static final int GremlinDamageMin = 15;
	private static final int GremlinDamageMax = 30;
	private static final int GremlinMinHeal = 20;
	private static final int GremlinMaxHeal = 40;
	
    public Gremlin()
	{
		super(GremlinName, GremlinHitPoints, GremlinAttackSpeed, GremlinChanceToHit,
				GremlinChanceToHeal, GremlinDamageMin, GremlinDamageMax, 
				GremlinMinHeal, GremlinMaxHeal);
		
	}
}
