package pickups;
import base_code.JHowes.DungeonCharacter;
import dungeon.Dungeon;

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