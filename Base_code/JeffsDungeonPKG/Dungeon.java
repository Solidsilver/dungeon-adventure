package base_code.JeffsDungeonPKG;

import java.util.ArrayList;
import java.util.Collections;

public class Dungeon {

	private int MAPSMAX_X = 4; // 1 based
	private int MAPSMAX_Y = 4; // 1 based
	private int EnterenceLocation = 0;
	private int ExitLocation = 0;
	private int CrownPiece1Location = 0;
	private int CrownPiece2Location = 0;
	private int herosXLocation = 0;
	private int herosYLocation = 0;
	private Room currentRoom;
	protected Room[][] roomsArray;
	
	//Map layout
	// Y,X 
	//(0,0) . . . . . . . (0,MAPSMAX_X)
	//. . . . . . . . .
	//. . . . . . . . .
	//(MAPSMAX_Y,0) . . . (MAPSMAX_Y,MAPSMAX_X)
	
	protected Dungeon() {
		//create and initialize all rooms in the 2D map.
		roomsArray = new Room[MAPSMAX_Y][MAPSMAX_X];
		for (int y = 0; y < MAPSMAX_Y; y++) {
			for(int x = 0; x < MAPSMAX_X; x++) {
				roomsArray[y][x] = new Room();				
				roomsArray[y][x].setRoomsXCoord(x);
				roomsArray[y][x].setRoomsYCoord(y);
				Room.mapsXWidth = MAPSMAX_X;
				Room.mapsYHeight = MAPSMAX_Y;
			}//end inner for loop			
		}//end outer for loop
		
			
		//get 4 random numbers and assign them to the entrance, exit, C1, and C2.  
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < MAPSMAX_X * MAPSMAX_Y; i++) {
			list.add(i);
		}
		Collections.shuffle(list);

		EnterenceLocation = list.get(0);
		ExitLocation = list.get(1);
		CrownPiece1Location = list.get(2);
		CrownPiece2Location = list.get(3);	
		
		//convert random int equal to the total number of elements in the 2D array.
		// Y location calc is int / Maps MAX X value.
		// X location calc is int Mod Maps MAX X value.
				
		//Clear out contents in those 4 rooms and set the contents to entrance, exit, C1, or C2
		roomsArray[EnterenceLocation / MAPSMAX_X][EnterenceLocation % MAPSMAX_X].clearRoomsContents();
		roomsArray[EnterenceLocation / MAPSMAX_X][EnterenceLocation % MAPSMAX_X].setHasEnterence(true);
		
		roomsArray[ExitLocation / MAPSMAX_X][ExitLocation % MAPSMAX_X].clearRoomsContents();
		roomsArray[ExitLocation / MAPSMAX_X][ExitLocation % MAPSMAX_X].setIsExit(true);
		roomsArray[ExitLocation / MAPSMAX_X][ExitLocation % MAPSMAX_X].setIsEmptyRoom(false);
		
		roomsArray[CrownPiece1Location / MAPSMAX_X][CrownPiece1Location % MAPSMAX_X].clearRoomsContents();
		roomsArray[CrownPiece1Location / MAPSMAX_X][CrownPiece1Location % MAPSMAX_X].setHasCrownPiece1(true);
		
		roomsArray[CrownPiece2Location / MAPSMAX_X][CrownPiece2Location % MAPSMAX_X].clearRoomsContents();
		roomsArray[CrownPiece2Location / MAPSMAX_X][CrownPiece2Location % MAPSMAX_X].setHasCrownPiece2(true);
		//		
	}// end of constr
	
	protected void setHeorsXLocation(int x) {
		herosXLocation = x;
	}
	
	protected void setHeorsYLocation(int y) {
		herosYLocation = y;
	}

	
	
	protected int getHerosXLocation() {
		return herosXLocation;
	}

	protected int getHerosYLocation() {
		return herosYLocation;
	}

	protected int getMAPSMAX_X() {
		return this.MAPSMAX_X;
	}
	
	protected int getMAPSMAX_Y() {
		return this.MAPSMAX_Y;
	}
	
	protected int getEntranceLocation() {
		return this.EnterenceLocation;
	}
	
	protected boolean isNextMoveValid(char direction) {
		// [Y] [X] change
		// N is [-1][0]
		// S is [+1][0]
		// W is [0][-1]
		// E is [0][+1]
		switch (direction) {
		
		case 'N':
			if (herosYLocation - 1 >= 0)
				return true;
			else
				return false;
		case 'S':
			if (herosYLocation + 1 <= (MAPSMAX_Y - 1)) // MAPSMAX_Y - 1 so number is zero based.
				return true;
			else
				return false;
		case 'W':
			if (herosXLocation - 1 >= 0)
				return true;
			else
				return false;
		case 'E':
			if (herosXLocation + 1 <= (MAPSMAX_X - 1)) // MAPSMAX_X - 1 so number is zero based.
				return true;
			else
				return false;
		default:
			return false;
		}
		
			
	}

	public void printMapTemp() {
		for (int y = 0; y < MAPSMAX_Y; y++) {
			for(int x = 0; x < MAPSMAX_X; x++) {
				System.out.print(roomsArray[y][x].getRoomsContents() + " ");
			}//end inner for loop	
			System.out.println("");
		}//end outer for loop		
	}
	
	//is this still needed?  this was stubbed in so it could be passed to the hero, when
	//it was going to determine if the next move was valid.
	protected Room[][] getDungeonMapRef(){
		return roomsArray;
	}
	
	//print the entire dungeon

	protected Room getCurrentRoom() {
		return roomsArray[this.herosYLocation][this.herosXLocation];
	}
	
	public String toString() {
		String result = "\n";
		for (int y = 0; y < MAPSMAX_Y; y++) {
			//print tops of each room, per line.
			for(int xT = 0; xT < MAPSMAX_X; xT++) {
				result += (roomsArray[y][xT].getRoomsYCoord() == 0 ? "* * " : "* - ");				
			}//end inner for loop	
			result += "*\n";
			
			//print middle section of each room, per line.
			for(int xM = 0; xM < MAPSMAX_X; xM++) {				
				if(y == herosYLocation && xM == herosXLocation)
					result += (roomsArray[y][xM].getRoomsXCoord() == 0 ? "* " : "| ") + "$" + " "; //if hero is standing in the room Print a $.
				else
					result += (roomsArray[y][xM].getRoomsXCoord() == 0 ? "* " : "| ") + roomsArray[y][xM].getRoomsContents() + " "; 
			}//end inner for loop
			result += "*\n";			
		}//end outer for loop
		
		//print bottom section of each room, per line.
		for(int xB = 0; xB < MAPSMAX_X; xB++) {
			result += ( "* * " );			
		}//end inner for loop	
		result += "*\n";
		
		return result;
		
	}
}// end of the Dungeon class
