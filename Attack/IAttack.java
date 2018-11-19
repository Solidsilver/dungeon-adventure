package Attack;

import characters.DungeonCharacter;

public interface IAttack {
	
	abstract void action(DungeonCharacter character, int min, int max);

}
