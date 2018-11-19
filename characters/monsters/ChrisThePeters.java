package characters.monsters;

public class ChrisThePeters extends Monster{

	private final String GremlinName = "Chris the Peters";
	private final int GremlinHitPoints = 50;
	private final int GremlinAttackSpeed = 4;
	private final double GremlinChanceToHit = 0.3;
	private final double GremlinChanceToHeal = 0.6;
	private final int GremlinDamageMin = 20;
	private final int GremlinDamageMax = 30;
	private final int GremlinMinHeal = 60;
	private final int GremlinMaxHeal = 70;
	
    public ChrisThePeters()
	{
		super();
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
