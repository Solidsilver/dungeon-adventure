package pickups;

import java.util.Random;

import characters.DungeonCharacter;
import dungeon.Dungeon;

public class HealingPotion extends PickupItem {

	String name = "Healing Potion";
	int HealingPotionsPoints = 0;
	int minHealingPotionPoints = 5; 
	int maxRandomHealingPointsPossible = 10;

	public HealingPotion() {
		this(null);
	}
	
	public HealingPotion(Dungeon dungeon) { //pass in a reference to to dungeon, it will 
		super("Healing Potion", dungeon);
		Random getAdditionalRandomHealingPoints = new Random();

		this.HealingPotionsPoints = minHealingPotionPoints + getAdditionalRandomHealingPoints.nextInt(maxRandomHealingPointsPossible); // 
	}

	public void use(DungeonCharacter dc) {

	}
	
}
//The Dungeon class will have to have a healing
