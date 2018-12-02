/**
 * @author Andrew Sales, Luke Mattfeld
 */
package pickups;

import pickups.PickupItem;
import characters.DungeonCharacter;
import dungeon.Dungeon;

public class Pillar extends PickupItem {
    public Pillar(Dungeon dungeon) {
        super("Pillar", dungeon);
    }

    @Override
    public void use(DungeonCharacter dc) {
        System.out.println("You can't do anything with this item");
    }
}