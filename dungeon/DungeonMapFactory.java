package dungeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import dungeon.room.Room;
import dungeon.room.*;

public class DungeonMapFactory implements Serializable {

	public static Room[][] createDungeonMap( int MAPSMAX_Y, int MAPSMAX_X, Dungeon dungeon){
		
		Room[][] roomsArray = new Room[MAPSMAX_Y][MAPSMAX_X];
				
				//get 6 random numbers and assign them to the entrance, exit, OOPillar pieces 1-4.  
			ArrayList<Integer> randomRoomNumberList = new ArrayList<Integer>();
			
			for (int i = 0; i < MAPSMAX_X * MAPSMAX_Y; i++) {
				
				randomRoomNumberList.add(i);
			}
			Collections.shuffle(randomRoomNumberList);
	
			int EnterenceLocation = randomRoomNumberList.get(0);
			int ExitLocation = randomRoomNumberList.get(1);
			int OOPillarPiece1Location = randomRoomNumberList.get(2);
			int OOPillarPiece2Location = randomRoomNumberList.get(3);	
			int OOPillarPiece3Location = randomRoomNumberList.get(4);	
			int OOPillarPiece4Location = randomRoomNumberList.get(5);	
						
			roomsArray[EnterenceLocation / MAPSMAX_X][EnterenceLocation % MAPSMAX_X]= RoomFactory.createRoom("Entrance", dungeon);
			roomsArray[ExitLocation / MAPSMAX_X][ExitLocation % MAPSMAX_X]= RoomFactory.createRoom("Exit", dungeon);
			roomsArray[OOPillarPiece1Location / MAPSMAX_X][OOPillarPiece1Location % MAPSMAX_X]= RoomFactory.createRoom("OOPillarPieceRoom", dungeon);
			roomsArray[OOPillarPiece2Location / MAPSMAX_X][OOPillarPiece2Location % MAPSMAX_X]= RoomFactory.createRoom("OOPillarPieceRoom", dungeon);
			roomsArray[OOPillarPiece3Location / MAPSMAX_X][OOPillarPiece3Location % MAPSMAX_X]= RoomFactory.createRoom("OOPillarPieceRoom", dungeon);
			roomsArray[OOPillarPiece4Location / MAPSMAX_X][OOPillarPiece4Location % MAPSMAX_X]= RoomFactory.createRoom("OOPillarPieceRoom", dungeon);
			
			for(int RandomRmNum = 6; RandomRmNum < MAPSMAX_X * MAPSMAX_Y; RandomRmNum++) {
				roomsArray[randomRoomNumberList.get(RandomRmNum) / MAPSMAX_X][randomRoomNumberList.get(RandomRmNum) % MAPSMAX_X]= RoomFactory.createRoom("NormalRoom", dungeon);
			}
		return roomsArray;
						
	}//end method createDungeonMap
	
			
}//end class DungeonMapFactory
