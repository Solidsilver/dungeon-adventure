package pickups;

import dungeon.Dungeon;
import characters.DungeonCharacter;

public class VisionPotion extends PickupItem {
    private Dungeon dungeon;
    public VisionPotion(Dungeon dungeon) {
        super("Vision Potion", dungeon);
    }
    public void use(DungeonCharacter dc) {
        this.inDungeon.printPlayerLocation();
    }
}