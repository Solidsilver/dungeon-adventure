package Attack;

import characters.DungeonCharacter;

/*
 **********************************
 * Author: Andrew Sales           *
 * ********************************
*/

public interface IAttack {
	
	abstract void action(DungeonCharacter character, DungeonCharacter opponent);

}
