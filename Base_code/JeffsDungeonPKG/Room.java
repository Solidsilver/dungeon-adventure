package DungeonPKG;

import java.util.Random;

/**
 * 
 * @author Jeff_PC
 *
 */
public class Room {

	private boolean containsHealingPotion = false;
	private boolean containsVisonPotion = false;
	private boolean containsPit = false;
	private boolean containsCrownPiece1 = false;
	private boolean containsCrownPiece2 = false;
	private boolean containsEnterence = false;
	private boolean containsExit = false;
	private boolean emptyRoom = false;
	private char roomsContentsLetter = 'E';
	private int roomsXCoord = 0;
	private int roomsYCoord = 0;

	public final int SPAWN_CHANCE_PERCENTAGE = 30; // 10%

	public Room() {
		setHasHealingPotion(willItemSpawn(SPAWN_CHANCE_PERCENTAGE));  	//using the spawn % to determine if the a healing potion will spawn in the room.
		setHasVisonPotion(willItemSpawn(SPAWN_CHANCE_PERCENTAGE)); 		//using the spawn % to determine if the a vision potion will spawn in the room.
		setHasPit(willItemSpawn(SPAWN_CHANCE_PERCENTAGE));				//using the spawn % to determine if the a pit will spawn in the room.
		roomsContentsLetter = getRoomsContents();
		if(roomsContentsLetter == 'E')
			this.setIsEmptyRoom(true);
		
	}// end default constr

	// Must be passed in a string Entrance, Exit, CrownPiece1, CrownPiece1  
	//public Room(String roomItem) {
	//
	//}// end explicit constr
	
	public boolean hasHealingPotion() {
		return containsHealingPotion;
	}

	public void setHasHealingPotion(boolean containsHealingPotion) {
		this.containsHealingPotion = containsHealingPotion;
	}

	public boolean hasVisonPotion() {
		return containsVisonPotion;
	}

	public void setHasVisonPotion(boolean containsVisonPotion) {
		this.containsVisonPotion = containsVisonPotion;
	}

	public boolean hasPit() {
		return containsPit;
	}

	public void setHasPit(boolean containsPit) {
		this.containsPit = containsPit;
	}

	public boolean hasContainsCrownPiece1() {
		return containsCrownPiece1;
	}

	public void setHasCrownPiece1(boolean containsCrownPiece1) {
		this.containsCrownPiece1 = containsCrownPiece1;
		this.roomsContentsLetter = 'C';
	}

	public boolean hasContainsCrownPiece2() {
		return containsCrownPiece2;		
	}

	public void setHasCrownPiece2(boolean containsCrownPiece2) {
		this.containsCrownPiece2 = containsCrownPiece2;
		this.roomsContentsLetter = 'C';
	}

	public boolean hasEnterence() {
		return containsEnterence;
	}

	public void setHasEnterence(boolean containsEnterence) {
		this.containsEnterence = containsEnterence;
		this.roomsContentsLetter = 'I';
	}

	public boolean isExit() {
		return containsExit;
	}

	public void setIsExit(boolean containsExit) {
		this.containsExit = containsExit;
		this.roomsContentsLetter = 'O';
	}

	public boolean isEmptyRoom() {
		return emptyRoom;
	}

	public void setIsEmptyRoom(boolean emptyRoom) {
		this.emptyRoom = emptyRoom;
	}

	public int getRoomsXCoord() {
		return roomsXCoord;
	}

	public void setRoomsXCoord(int roomsXCoord) {
		this.roomsXCoord = roomsXCoord;
	}

	public int getRoomsYCoord() {
		return roomsYCoord;
	}

	public void setRoomsYCoord(int roomsYCoord) {
		this.roomsYCoord = roomsYCoord;
	}

	public boolean willItemSpawn(int chance) {

		boolean result = false;
		Random r = new Random();

		if (r.nextInt(100) < chance) // 0-9 (10%) spawn, 10-99 (90%) don't spawn
			result = true;
		return result;
	}// end method willItemSpawn
	
	
	public char getRoomsContents() {
				
		if(containsEnterence)
			return 'I';
		if(containsExit)
			return 'O';
		if(containsCrownPiece1  || containsCrownPiece2 )
			return 'C';
		if(containsPit && !containsHealingPotion  && !containsVisonPotion) //contains only a pit
			return 'P';
		if(containsHealingPotion && !containsVisonPotion  && !containsPit ) //contains only a healing potion
			return 'H'; 
		if(containsVisonPotion  && !containsPit  && !containsHealingPotion ) //contains only a  vision potion
			return 'V'; 
		if(!containsPit  && !containsHealingPotion && !containsVisonPotion ) //don't not contain any items
			return 'E'; //Room is Empty
		else
			return 'M'; // multiple items must be in the room. 
		
	}// end of method getRoomsContents
	
	public void clearRoomsContents() {
		containsHealingPotion = false;
		containsVisonPotion = false;
		containsPit = false;
	}
	
	protected void updateRoomsContentLetter() {
		if(this.containsPit == false && this.containsEnterence == false && this.containsExit == false) {
			this.roomsContentsLetter = 'E';
			this.setIsEmptyRoom(true);
		}
			
		
	}

	public String toString () {  //change the XCoord and Y Coord
		String result;
		//char RmsItem = 'M';
		// * * *    <- Top line 
		// * M |    <- Middle line
		// * - *	<- Bottom line
		
		// Top line: 	will always start & end with a "*" but the middle symbol be a "*" when room is on the top row (Y = 0) then there is not door and "*" is printed 
		// Middle line:	first symbol will be * when room is on the left border (x = 0).  The center symbol will always display a char with represents the rooms contents.  The last symbol will by * when the room on the right side board (X = 4)  
		// Bottom line: 
		
		result = "Room's coordinates are " + (this.getRoomsXCoord() +1) + ", " + (this.getRoomsYCoord() +1) + "\n";
		result +=  (roomsYCoord == 0 ? "* * *\n" : "* - *\n"); 																	//Top line		 	
		result += (roomsXCoord == 0 ? "* " : "| ") + roomsContentsLetter + (roomsXCoord == (mapsXWidth -1) ? " *\n" : " |\n");  // Middle line
		result += (roomsYCoord == mapsYHeight -1 ? "* * * " : "* - * "); 														// Bottom line
		
		return result;
	}
	
	//Class variables 
	public static int mapsXWidth = 0;
	public static int mapsYHeight = 0;
}// end room class
