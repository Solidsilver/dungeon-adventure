package tempPackage;

public  class RoomFactory {

	public static Room createRoom(String roomType, Dugneon dungeon)  {  //Room types are Entrance, Exit, OOPillarPieceRoom, NormalRoom 
		
		if(roomType == "Entrance") {
			Room room = new Room("Entrance", dungeon);	
			return room;
		}
		
		else if(roomType == "Exit") {
			Room room = new Room("Exit", dungeon);
			return room;
		}
		
		else if(roomType == "OOPillarPieceRoom") {
			Room room = new Room("OOPillarPieceRoom", dungeon);	
			return room;
		}
		
		else  {
			Room room = new Room("NormalRoom", dungeon);	
			return room;
		}
		
	}
}
