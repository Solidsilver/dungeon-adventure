package characters.monsters;

public class Gremlin extends Monster{

	private final String GremlinName = "Gnarltooth the Gremlin";
	private final int GremlinHitPoints = 70;
	private final int GremlinAttackSpeed = 5;
	private final double GremlinChanceToHit = 0.8;
	private final double GremlinChanceToHeal = 0.4;
	private final int GremlinDamageMin = 15;
	private final int GremlinDamageMax = 30;
	private final int GremlinMinHeal = 20;
	private final int GremlinMaxHeal = 40;
	
    public Gremlin()
	{
		super(/*"Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40*/);
		this.name = GremlinName;
		this.hitPoints = GremlinHitPoints;
		this.attackSpeed = GremlinAttackSpeed;
		this.chanceToHit = GremlinChanceToHit;
		this.chanceToHeal = GremlinChanceToHeal;
		this.damageMin = GremlinDamageMin;
		this.damageMax = GremlinDamageMax;
		this.minHeal = GremlinMinHeal;
		this.maxHeal = GremlinMaxHeal;
	}
}
