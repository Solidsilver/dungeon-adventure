package tempPackage;

public class Print {

	public static void singleRoom(Room[][] roomsArray, int herosXLocation, int herosYLocation) {
		int upperLeftXCoord, upperLeftYCoord, lowerRightXCoord, lowerRightYCoord;
		
		upperLeftXCoord = lowerRightXCoord = herosXLocation;
		upperLeftYCoord = lowerRightYCoord = herosYLocation;
		
		printSpecificRooms(roomsArray, upperLeftXCoord, upperLeftYCoord, lowerRightXCoord, lowerRightYCoord, herosXLocation, herosYLocation);		
	}
	
	public static void roomsUsingVisionPotion(Room[][] roomsArray, int herosXLocation, int herosYLocation) {
		 int upperLeftXCoord, upperLeftYCoord, lowerRightXCoord, lowerRightYCoord;
		 
		 upperLeftXCoord = herosXLocation == 0 ? 0 : herosXLocation -1;
		 upperLeftYCoord = herosYLocation == 0 ? 0 : herosYLocation -1;
		 int MapsMax_X = roomsArray[0].length -1;
		 int MapsMax_Y = roomsArray.length -1;
		 
		 //lowerRightXCoord = herosXLocation ==  (roomsArray[0].length -1) ? (roomsArray[0].length -1) : herosXLocation +1;
		 if(herosXLocation ==  (MapsMax_X) ) {
			 lowerRightXCoord = (MapsMax_X);  
		 }
		 else
			 lowerRightXCoord = herosXLocation +1;
		 
		 //lowerRightYCoord = herosYLocation ==  (roomsArray.length -1)    ? (roomsArray.length -1) : herosYLocation +1;
		if(herosYLocation ==  MapsMax_Y ) 
			lowerRightYCoord = MapsMax_Y;
		else
			lowerRightYCoord = (herosYLocation +1);	 
		 
		 printSpecificRooms(roomsArray, upperLeftXCoord, upperLeftYCoord, lowerRightXCoord, lowerRightYCoord, herosXLocation, herosYLocation);
	}
	
	public static void fullMap(Room[][] roomsArray, int herosXLocation, int herosYLocation) {
		printSpecificRooms(roomsArray, 0, 0, roomsArray[0].length -1, roomsArray.length -1, herosXLocation, herosYLocation);		
	}//end fullMap method

	public static void printSpecificRooms(Room[][] roomsArray, int upperLeftXCoord, 
			int upperLeftYCoord, int lowerRightXCoord, int lowerRightYCoord, int herosXLocation, int herosYLocation){
		//loop variables: 
		// 		xT Top lines x
		// 		xM Mid lines x
		// 		xB Bot lines x
		
		int y,xT, xM, xB;
		
		for (y = upperLeftYCoord; y <= lowerRightYCoord; y++) {
			
			//print tops of each room, per line.
			for(xT = upperLeftXCoord; xT <= lowerRightXCoord; xT++) {
				System.out.print(y == 0 ? "* * " : "* - ");							
			}//end inner for loop				
			System.out.println("*"); 
			
			
			//print middle section of each room, per line.
			for(xM = upperLeftXCoord; xM <= lowerRightXCoord; xM++) {				
				if(y == herosYLocation && xM == herosXLocation)
					System.out.print ( (xM == 0 ? "* " : "| ") + "$" + " "); //if hero is standing in the room Print a $.
				else
					System.out.print ( (xM == 0 ? "* " : "| ") + roomsArray[y][xM].getRoomsContents() + " "); 
			}//end inner for loop
			if(xM == roomsArray[0].length)
			System.out.println("*");		
			else
				System.out.println("|");		
		}//end outer for loop
		
		y++;
		//print bottom section of each room, per line.
		//print tops of each room, per line.
		for(xB = upperLeftXCoord; xB <= lowerRightXCoord; xB++) {
			System.out.print(y == roomsArray[0].length-1 ? "* * " : "* - ");							
		}//end inner for loop				
		System.out.println("*");
		
		/*
		for(xB = upperLeftXCoord; xB <= lowerRightXCoord; xB++) {
			System.out.print ( "* " );			
		}//end inner for loop	
		if(y == roomsArray[0].length)
			System.out.println("*");		
			else
				System.out.println("* -");
				*/
	}
	
	
	
	
	
	
	
}//end of Print class


/*
 * public static void room(Room[][] roomsArray, int roomsXCoord, int roomsYCoord) {
		
		String result;
		//char RmsItem = 'M';
		// * * *    <- Top line 
		// * M |    <- Middle line
		// * - *	<- Bottom line
		
		// Top line: 	will always start & end with a "*" but the middle symbol be a "*" when room is on the top row (Y = 0) then there is not door and "*" is printed 
		// Middle line:	first symbol will be * when room is on the left border (x = 0).  The center symbol will always display a char with represents the rooms contents.  The last symbol will by * when the room on the right side board (X = 4)  
		// Bottom line: 
		
		System.out.println("Room's coordinates are " + (roomsXCoord +1) + ", " + (roomsYCoord +1) );							//Header line
		System.out.println( roomsYCoord == 0 ? "* * *\n" : "* - *"); 															//Top line		 	
		System.out.println((roomsXCoord == 0 ? "* " : "| ") + roomsArray[roomsYCoord][roomsXCoord].getRoomsContents() 
				+ (roomsXCoord == (roomsArray[0].length -1) ? " *" : " |") );  													// Middle line
		System.out.println(roomsYCoord == roomsArray.length -1 ? "* * * " : "* - * "); 											// Bottom line
		
		
		}
*/
		
/*
 * public static void fullMap(Room[][] roomsArray, int herosXLocation, int herosYLocation) {
		
		//loop variables: 
		// 		xT Top lines x
		// 		xM Mid lines x
		// 		xB Bot lines x
		
		for (int y = 0; y < roomsArray.length -1; y++) {
			
			//print tops of each room, per line.
			for(int xT = 0; xT < roomsArray[0].length -1; xT++) {
				System.out.print(y == 0 ? "* * " : "* - ");				
			}//end inner for loop	
			System.out.println("*"); 
			
			//print middle section of each room, per line.
			for(int xM = 0; xM < roomsArray[0].length -1; xM++) {				
				if(y == herosYLocation && xM == herosXLocation)
					System.out.print ( (xM == 0 ? "* " : "| ") + "$" + " "); //if hero is standing in the room Print a $.
				else
					System.out.print ( (xM == 0 ? "* " : "| ") + roomsArray[y][xM].getRoomsContents() + " "); 
			}//end inner for loop
			System.out.println("*");			
		}//end outer for loop
		
		//print bottom section of each room, per line.
		for(int xB = 0; xB < roomsArray[0].length -1; xB++) {
			System.out.print ( "* * " );			
		}//end inner for loop	
		System.out.println("*");
	}//end fullMap method
	*/
	
 

