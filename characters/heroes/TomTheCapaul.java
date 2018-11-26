package characters.heroes;

public class TomTheCapaul extends Hero{

	private static final String TomName = "Tom the Capaul";
	private static final int TomHitPoints = 100;
	private static final int TomAttackSpeed = 10;
	private static final double TomChanceToHit = 1;
	private static final int TomDamageMin = 100;
	private static final int TomDamageMax = 100;
	private static final double TomChanceToBlock = 1;

	public TomTheCapaul()
	{
		super(TomName, TomHitPoints, TomAttackSpeed, TomChanceToHit, TomDamageMin,
				TomDamageMax, TomChanceToBlock, "Crushing Blow");
    }//end constructor
	
}
