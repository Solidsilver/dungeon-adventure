package Attack;

import characters.DungeonCharacter;

public interface IAttack {
	
	abstract void action(DungeonCharacter character, DungeonCharacter opponent);

}
