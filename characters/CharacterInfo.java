package characters;

public class CharacterInfo {

	private static CharacterInfo instance = null;
	
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
