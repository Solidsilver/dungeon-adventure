package pickups;
import dungeon.Dungeon;

public abstract class PickupItem {
    private String name;
    private Dungeon inDungeon;
    public abstract void use();

    public PickupItem(String name, Dungeon dung) {
        this.name = name;
        this.inDungeon = dung;
    }

    public String getName() {
        return this.name;
    }
}