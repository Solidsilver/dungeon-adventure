package characters.monsters;

public class BrianTheCamp extends Monster{

	private final String GremlinName = "Brian The Camp";
	private final int GremlinHitPoints = 90;
	private final int GremlinAttackSpeed = 4;
	private final double GremlinChanceToHit = 0.9;
	private final double GremlinChanceToHeal = 0.6;
	private final int GremlinDamageMin = 50;
	private final int GremlinDamageMax = 70;
	private final int GremlinMinHeal = 10;
	private final int GremlinMaxHeal = 50;
	
    public BrianTheCamp()
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
