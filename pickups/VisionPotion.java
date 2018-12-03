/**
 * @author Luke Mattfeld, Jeff Howes
 */
package pickups;

import dungeon.Dungeon;
import characters.DungeonCharacter;

public class VisionPotion extends PickupItem {
    private static final long serialVersionUID = 1L;
    public VisionPotion(Dungeon dungeon) {
        super("Vision Potion", dungeon);
    }
    public void use(DungeonCharacter dc) {
        this.inDungeon.printPlayerLocation();
    }
}