package base_code.JeffsDungeonPKG;

import java.util.Random;

public class Hero {

	private int hitPointsCount = 0;
	private int healingPotionsCount = 0;
	private int visionPotionsCount = 0;
	private int crownPiecesFound = 0;
	private boolean FoundBothPeices = false;
	private int herosXCoord = 0;
	private int herosYCoord = 0;
	private Room[][] dungeonMapArray;  
	private Dungeon dungeonRef;
	private final int MAX_INIT_HIT_POINTS_DELTA = 2; // should be 25
	private final int MAX_INIT_HIT_POINTS_OFFSET = 1; // should be 75
	
	protected Hero() {
		Random r = new Random();
		setHitPoints((r.nextInt(MAX_INIT_HIT_POINTS_DELTA)) + MAX_INIT_HIT_POINTS_OFFSET);
		
		
	}//end constructor
	
	protected void setDungeonRef(Dungeon myDungeonRef) {
		this.dungeonRef = myDungeonRef;
		dungeonMapArray = myDungeonRef.getDungeonMapRef();
	}
	//hit points will be a + or - value depending on if they are healing or damage points. 
 	protected void setHitPoints(int HP) {
		this.hitPointsCount += HP;
	}
	
 	protected int getHitPoints() {
 		return this.hitPointsCount;
 	}
		
	protected void incHealingPotionCount() {
		healingPotionsCount += 1;
	}
	
	protected void incVisionPotionsCount() {
		visionPotionsCount += 1;
		System.out.println("Debug -- incVisionPotionsCount called");
		System.out.println("vision postion count in hero: " + this.visionPotionsCount );
	}
	
	protected void decHealingPotionCount() {
		healingPotionsCount -= 1;
	}
	
	protected void decVisionPotionsCount() {
		visionPotionsCount -= 1;
	}
	
	protected int getHealingPotionCount() {
		return this.healingPotionsCount;
	}
	
	protected int getVisionPotionCount() {
		return this.visionPotionsCount;
	}
	
	protected void useHealingPotion() {
		Random r = new Random();
		int tempHitPoints =0;
		
		tempHitPoints = r.nextInt(10) + 5;
		setHitPoints(tempHitPoints); //heals randomly between 5-15
		System.out.println("Healing posion used - adding " + tempHitPoints + " hit points");
		decHealingPotionCount();
	}
	
	protected void incCrownPeicesFound() {
		crownPiecesFound += 1;		
		if(crownPiecesFound == 2) {
			FoundBothPeices = true;
			System.out.println("You have found both coding Crown pieces! Great job, now get out!");
		}
	}
	
	public int getHerosXCoord() {
		return herosXCoord;
	}

	public void setHerosXCoord(int herosXCoord) {
		this.herosXCoord = herosXCoord;
	}

	public int getHerosYCoord() {
		return herosYCoord;
	}

	public void setHerosYCoord(int herosYCoord) {
		this.herosYCoord = herosYCoord;
	}

	protected void moveHero(char direction) {
		// 		[Y] [X] change
		// N is [-1][0]
		// S is [+1][0]
		// W is [0][-1]
		// E is [0][+1]
		
		int x = this.getHerosXCoord();
		int y = this.getHerosYCoord();
		
		//System.out.println("DEBUG  --- printing this.getHerosXCoord() " + this.getHerosXCoord() + "; printing this.getHerosYCoord() " + this.getHerosYCoord() );
		switch (direction) {
		
		case 'N':
			enterRoom(y-1, x);
			this.setHerosYCoord(y-1);	
			dungeonRef.setHeorsYLocation(y-1);
			
			//System.out.println("DEBUG  --- printing this.getHerosXCoord() " + this.getHerosXCoord() + "; printing this.getHerosYCoord() " + this.getHerosYCoord() );
			//System.out.println("DEBUG  --- printing dungeonRef.getHerosXLocation() " + dungeonRef.getHerosXLocation() + "; printing dungeonRef.getHerosYLocation() " + dungeonRef.getHerosYLocation() );
			break;
		case 'S':
			enterRoom(y+1, x);
			this.setHerosYCoord(y+1);	
			dungeonRef.setHeorsYLocation(y+1);
			break;
		case 'W':
			enterRoom(y, x-1);
			this.setHerosXCoord(x-1);
			dungeonRef.setHeorsXLocation(x-1);
			break;
		case 'E':
			enterRoom(y, x+1);
			this.setHerosXCoord(x+1);
			dungeonRef.setHeorsXLocation(x+1);
			break;
		default:
			break;
		}
	}
	
	protected void enterRoom(int y, int x) {
		
		if(dungeonMapArray[y][x].isEmptyRoom() ) {
			System.out.println("Room was empty.");
		}
				
		if(dungeonMapArray[y][x].hasPit()) {
			int tempHitPoints = 0;
			
			tempHitPoints = calcPitsDamage() * -1;
			this.setHitPoints(tempHitPoints); //convert positive random num to a neg to subtract the hit points
			System.out.println("You fell into a pit! Pit's damage was " + (tempHitPoints * -1) + " hit points.");
			// pit will remain in the room.
		}//end if
		
		if(dungeonMapArray[y][x].hasHealingPotion()){
			System.out.println("Healing potion found! Adding it to your inventory.");
			this.incHealingPotionCount();
			dungeonMapArray[y][x].setHasHealingPotion(false);
		}
		
		if(dungeonMapArray[y][x].hasVisonPotion()) {
			System.out.println("Vision potion found! Adding it to your inventory.");
			this.incVisionPotionsCount();
			dungeonMapArray[y][x].setHasVisonPotion(false);
		}
			
		if(dungeonMapArray[y][x].hasContainsCrownPiece1()) {
			System.out.println("You found a coding Crown piece! Adding it to your inventory.");
			this.incCrownPeicesFound();
			dungeonMapArray[y][x].setHasCrownPiece1(false);
		}
		
			
		if(dungeonMapArray[y][x].hasContainsCrownPiece2()) {
			System.out.println("You found a coding Crown piece! Adding it to your inventory.");
			this.incCrownPeicesFound();
			dungeonMapArray[y][x].setHasCrownPiece2(false);
		}
		
			
	}
	
	protected int calcPitsDamage() {
		Random r = new Random();
		return (r.nextInt(20) + 1);  // returns a random # from 1 - 20. 
	}
	
	
	protected boolean hasFoundBothCrownPeices() {		
		return this.FoundBothPeices;
	}
	
	public String toString() {
		String result;
		result = ("Hero's Stats:\n");
		result += ("Hit points: " + this.hitPointsCount + "\n");
		result += ("Healing potions: " + this.getHealingPotionCount() + "\n");
		result += ("Vision potions: " + this.visionPotionsCount + "\n");
		result += ("Coding Crown peices found: " + this.crownPiecesFound + "\n");
		return result;
		
	}//end toString
}//end of hero class
