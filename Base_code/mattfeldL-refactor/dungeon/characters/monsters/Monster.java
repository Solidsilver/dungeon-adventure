package dungeon.characters.monsters;

import dungeon.characters.DungeonCharacter;

public abstract class Monster extends DungeonCharacter {
	protected double chanceToHeal;
	protected int minHeal, maxHeal;

	Monster(String name, int healthPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin,
			int damageMax, int minHeal, int maxHeal) {
		super(name, healthPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToHeal = chanceToHeal;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;

	}// end monster construcotr

	public void heal() {
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (healthPoints > 0);

		if (canHeal) {
			healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			inflictDamage(healPoints);
			System.out.println(characterName + " healed itself for " + healPoints + " points.\n"
					+ "Total hit points remaining are: " + healthPoints);
			System.out.println();
		} // end can heal

	}// end heal method

	@Override
	public void inflictDamage(int hitPoints) {
		super.inflictDamage(hitPoints);
		heal();
	}

}// end Monster class