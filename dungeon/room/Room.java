package dungeon.room;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Jeff_PC
 *
 */
public class Room {

	public ArrayList<String> roomsContents = new ArrayList<String>();  //HealingPostion, VisionPostion, OOPillarPiece
	
	//private boolean containsHealingPotion = false;
	//private boolean containsVisonPotion = false;	
	//private boolean containsCrownPiece1 = false;
	//private boolean containsCrownPiece2 = false;
	
	private boolean containsEnterence = false;
	private boolean containsExit = false;
	private boolean emptyRoom = false;
	private char roomsContentsLetter = 'E';
	
	private boolean containsPit = false;
	private boolean containsMonster = false;	

	public final int SPAWN_CHANCE_PERCENTAGE = 30; // 10%

	public Room(String roomType) 
		{
			if(roomType == "Entrance")
			{
				this.containsEnterence = true;
				this.roomsContentsLetter = 'I';
			}
			else if(roomType == "Exit")
			{
				this.containsExit = true;
				this.roomsContentsLetter = 'O';
			}
			else if(roomType == "OOPillarPieceRoom")
			{
				this.setHasOOPilarPiece();
				this.roomsContentsLetter = 'T';
			}
			else { //"Normal room"
				setHasHealingPotion(willItemSpawn(SPAWN_CHANCE_PERCENTAGE));  	//using the spawn % to determine if the a healing potion will spawn in the room.
				setHasVisionPotion(willItemSpawn(SPAWN_CHANCE_PERCENTAGE)); 	//using the spawn % to determine if the a vision potion will spawn in the room.
				setHasPit(willItemSpawn(SPAWN_CHANCE_PERCENTAGE));				//using the spawn % to determine if the a pit will spawn in the room.
				setHasMonster(willItemSpawn(SPAWN_CHANCE_PERCENTAGE));			//using the spawn % to determine if the a Monster will spawn in the room.
				roomsContentsLetter = getRoomsContents();
				if(roomsContentsLetter == 'E')
					this.setIsEmptyRoom(true);
			}	
	}// end default constr
	
	
	public ArrayList<String> getRmsContents(){
		return this.roomsContents;
		
	}
	public boolean hasPit() {
		return containsPit;
	}
	
	public boolean hasMonster() {
		return containsMonster;
	}

	public void setHasPit(boolean containsPit) {
		this.containsPit = containsPit;
	}
	
	public void setHasMonster(boolean containsMonster) {
		this.containsMonster = containsMonster;
	}

	public void setHasHealingPotion(boolean containsHealingPotion) {
		if(containsHealingPotion)
			roomsContents.add("HealingPotion");
	}
	
	public void setHasVisionPotion(boolean containsVisionPotion) {
		if(containsVisionPotion)
			roomsContents.add("VisionPotion");
	}	

	public void setHasOOPilarPiece() {		
		roomsContents.add("OOPillarPiece");
	}	

	public boolean hasEnterence() {
		return containsEnterence;
	}

	public void setHasEnterence() {
		this.containsEnterence = true;
		this.roomsContentsLetter = 'I';
	}

	public boolean isExit() {
		return containsExit;
	}

	public void setIsExit() {
		this.containsExit = true;
		this.roomsContentsLetter = 'O';
	}

	//public boolean isEmptyRoom() {
	//	return emptyRoom;
	//}

	public void setIsEmptyRoom(boolean emptyRoom) {
		this.emptyRoom = emptyRoom;
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
		//if(containsCrownPiece1  || containsCrownPiece2 )
		if(RoomHasContentsOf("OOPillarPiece") && !containsPit && !containsMonster)
			return 'T';	//T is for Treasure
		if(containsPit && !containsMonster && roomsContents.size() == 0) //contains only a pit
			return 'P';
		if(containsMonster && !containsPit && roomsContents.size() == 0)
			return 'R'; //R is for Monster, since M was already taken
		if(RoomHasContentsOf("HealingPostion") && !RoomHasContentsOf("VisionPostion") && !RoomHasContentsOf("OOPillarPiece") && !containsPit && !containsMonster) //contains only a healing potion
			return 'H'; 
		if(RoomHasContentsOf("VisionPostion") && !RoomHasContentsOf("HealingPostion") && !RoomHasContentsOf("OOPillarPiece") && !containsPit && !containsMonster) //contains only a  vision potion
			return 'V'; 		
		if( !containsPit  && !containsMonster && roomsContents.size() > 0) //don't not contain any items
			return 'E'; //Room is Empty
		else
			return 'M'; // multiple items must be in the room. 
		
	}// end of method getRoomsContents
	
	//Check to see if the room contents contains "VisionPostion", "HealingPostion", or a "OOPillarPiece". 
	public boolean RoomHasContentsOf(String typeOfContent) {		
		if(roomsContents.contains(typeOfContent) )
			return true;			
		
		return false;
	}
	public void clearRoomsContents() {	
		roomsContents.clear();
		containsMonster = false;
		//Pit remains in room
	}
	
	protected void updateRoomsContentLetter() {
		if(!this.containsPit && !this.containsMonster && roomsContents.size()==0 &&  !this.containsEnterence  && !this.containsExit) {
			this.roomsContentsLetter = 'E';
			this.setIsEmptyRoom(true);
		}	
	}
	
	public void printRoom () {  //change the XCoord and Y Coord
		String result;
		//char RmsItem = 'M';
		// * * *    <- Top line 
		// * M |    <- Middle line
		// * - *	<- Bottom line
		
		// Top line: 	will always start & end with a "*" but the middle symbol be a "*" when room is on the top row (Y = 0) then there is not door and "*" is printed 
		// Middle line:	first symbol will be * when room is on the left border (x = 0).  The center symbol will always display a char with represents the rooms contents.  The last symbol will by * when the room on the right side board (X = 4)  
		// Bottom line: 
		
		
		System.out.println  ("* * *"); 							//Top line		 	
		System.out.println("* "  + roomsContentsLetter +  " *");  // Middle line
		System.out.println("* * * "); 							// Bottom line
		
		
		}
	
}// end room class





///////Removed to support the Room's Contents ArrayList
/*
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
*/

/*  //Should be moved to a map printing class, so the room does not need to know it location.  
 * public String toString () {  //change the XCoord and Y Coord
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
 * 
 */

