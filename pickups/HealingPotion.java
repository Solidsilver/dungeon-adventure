package pickups;

import base_code.JHowes.DungeonCharacter;

public class HealingPotion extends PickupItems {
    public HealingPotion(Dugneon dungeon) {
        super("Healing Potion", dungeon);
    }

    public void use(DungeonCharacter dc) {
        dc.addHitPoints(val);
    }

}