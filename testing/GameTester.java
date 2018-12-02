package testing;


import dungeon.room.Room;

public class GameTester {

	public  void tester(Room[][] dungeonMap, int MapsMax_X, int MapsMax_Y) {
		for (int y=0; y < MapsMax_Y; y++ ) 
		{
			for(int x=0; x < MapsMax_X; x++) 
			{
				dungeonMap[y][x].printRoom();
			}
			//System.out.println("");
		}
	}
	
}
