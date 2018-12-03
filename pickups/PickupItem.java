/**
 * @author Luke Mattfeld, Jeff Howes
 */
package pickups;
import dungeon.Dungeon;

import java.io.Serializable;

import characters.DungeonCharacter;

public abstract class PickupItem implements Serializable {
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

    public String toString() {
        return this.getName();
    }
}