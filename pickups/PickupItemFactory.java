package pickups
import java.util.ArrayList;

import pickups.PickupItem;
import pickups.VisionPotion;

public class PickupItemFactory {
    private ArrayList<String> buildable;
    public PickupItemFactory() {   
        this.buildable = new ArrayList<>();
    }

    public PickupItem makeItem(String itemName) {

    }

    public PickupItem makeItem(int itemID) {
        switch (itemID) {
            case 0:
                return new VisionPotion(null);
                break;
            case 1:
            default:
                break;
        }
    }
}