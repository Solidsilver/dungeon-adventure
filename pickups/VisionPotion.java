package pickups;

public class VisionPotion extends PickupItem {
    public VisionPotion(Dugneon dungeon) {
        super("Vision Potion", dungeon);
    }

    public void use(DungeonCharacter dc) {
        this.inDungeon.printPlayerLocation();
    }
}