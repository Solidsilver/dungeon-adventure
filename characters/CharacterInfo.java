package characters;

public class CharacterInfo {

	private static CharacterInfo instance = null;
	
	private String name;
	private int hitPoints;
	private int attackSpoints;
	private double chanceToHit;
	private int damageMin;
	private int damageMax;
	private double chanceToBlock;
	
	private CharacterInfo() {};	
	public CharacterInfo getCharacterInfo()
	{
		if(instance == null)
		{
			instance = new CharacterInfo();
		}
		return instance;
	}
	
	
	
	
}
