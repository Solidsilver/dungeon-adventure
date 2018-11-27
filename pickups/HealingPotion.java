package pickups;

import java.util.Random;

public class HealingPotion extends PickupItem {

	String name = "Healing Potion";
	int HealingPotionsPoints = 0;
	int minHealingPotionPoints = 5; 
	int maxRandomHealingPointsPossible = 10;
	
	public void HealingPotion(Dungeon dungeon) { //pass in a reference to to dungeon, it will 
		Random getAdditionalRandomHealingPoints = new Random();

		HealingPotionsPoints = minHealingPotionPoints + getAdditionalRandomHealingPoints.nextInt(maxRandomHealingPointsPossible); // 
	}
	
}
//The Dungeon class will have to have a healing
