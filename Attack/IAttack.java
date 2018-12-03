package Attack;

import characters.DungeonCharacter;

/**
 * @author Andrew Sales
 */

public interface IAttack {
	
	abstract void action(DungeonCharacter character, DungeonCharacter opponent);

}
