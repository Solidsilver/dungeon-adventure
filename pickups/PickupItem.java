package pickups;
import dungeon.Dungeon;
import characters.DungeonCharacter;

public abstract class PickupItem {
    private String name;
    protected Dungeon inDungeon;

    public abstract void use(DungeonCharacter dc);

    public PickupItem(String name, Dungeon dung) {
        this.name = name;
        this.inDungeon = dung;
    }

    public String getName() {
        return this.name;
    }
}