package dungeon.room;

public  class RoomFactory {

	public static Room createRoom(String roomType)  {  //Room types are Entrance, Exit, OOPillarPieceRoom, NormalRoom 
		
		if(roomType == "Entrance") {
			Room room = new Room("Entrance");	
			return room;
		}
		
		else if(roomType == "Exit") {
			Room room = new Room("Exit");
			return room;
		}
		
		else if(roomType == "OOPillarPieceRoom") {
			Room room = new Room("OOPillarPieceRoom");	
			return room;
		}
		
		else  {
			Room room = new Room("NormalRoom");	
			return room;
		}
		
	}
}
