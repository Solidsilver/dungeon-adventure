package pickups;

import pickups.PickupItem;

public class Pillar extends PickupItem {
    public Pillar(Dugneon dungeon) {
        super("Pillar", dungeon);
    }

    @Override
    public void use(DungeonCharacter dc) {
        System.out.println("You can't do anything with this item");
    }
}