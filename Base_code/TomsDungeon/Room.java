import java.util.Random;

public class Room
{
	private int row, col;
	private int maxRow, maxCol;
	
	private int hasHealthPotion,
						 hasPit,
						 hasVisionPotion,
						 hasCrownPiece;
	private int itemChance;
	
	private boolean isEntrance, isExit;
	
	public Room(int row, int col, int maxRow, int maxCol)
	{
		this.row = row;
		this.col = col;
		this.maxRow = maxRow;
		this.maxCol = maxCol;
		
		this.itemChance = 10;
		generateItems();
		 
		
		
	
	}
	
	private void generateItems()
	{
		Random random = new Random();
		
		hasHealthPotion = random.nextInt(100) < this.itemChance ? 1 : 0;
		hasPit = random.nextInt(100) < this.itemChance ? 1 : 0;
		hasVisionPotion = random.nextInt(100) < this.itemChance ? 1 : 0;
	
	
	}//end generateItems
	
	public String determineRoomLetter()
	{
		String result = "";
		int itemCount = hasHealthPotion + hasPit + hasVisionPotion + hasCrownPiece;
		
		if (isEntrance)
			return "I";
		if (isExit)
			return "O";
		if (itemCount == 0)
			return "E";
		if (itemCount > 1)
			return "M";
		if (hasHealthPotion == 1)
			return "H";
		if (hasPit == 1)
			return "P";
		if (hasVisionPotion == 1)
			return "V";
		if (hasCrownPiece == 1)
			return "C";
			
		return "?"; //should not get here!
		
	
	}
	
	private void clearData()
	{
		this.hasHealthPotion = this.hasPit = this.hasVisionPotion = 0;
	
	}
	
	public void setEntrance()
	{
		clearData();
		this.isEntrance = true;
	
	}
	
	public void setExit()
	{
		clearData();
		this.isExit = true;
	
	
	}
	
	public void setCrown()
	{
		this.hasCrownPiece = 1;
	
	}
	
	public String topRowString()
	{
		String result = "*";
		if (row == 0)
			result += "*";
		else
			result += "-";
			
		result += "*";
			
		return result;
	
	}
	
	public String middleRowString()
	{
		String result = "";
		if (col == 0)
			result += "*";
		else
			result += "|";
			
		result += determineRoomLetter();
		
		if (col == maxCol - 1)
			result += "*";
		else
			result += "|";
			
		return result;
	
	}//end middleRowString
	
	public String bottomRowString()
	{
		String result = "*";
		if (row == maxRow - 1)
			result += "*";
		else
			result += "-";
			
		result += "*";
			
		return result;
	
	}
	
	public String toString()
	{
		String result = topRowString() + "\r\n";
		result += middleRowString() + "\r\n";
		result += bottomRowString() + "\r\n";
		
		return result;
	
	}
	
	public String toStringDungeon(Room [][] dungeon)
	{
		String result = "";
		
		for (int row = 0; row < dungeon.length; row++)
		{
			if (row == 0)
			{
				for (int col = 0; col < dungeon[row].length; col++)
				{
					result += dungeon[row][col].topRowString();
					
					
				}
				result += "\r\n";
			}
			
			for (int col = 0; col < dungeon[row].length; col++)
			{
				result += dungeon[row][col].middleRowString();
				
				
			}
			result += "\r\n";
			
			for (int col = 0; col < dungeon[row].length; col++)
			{
				result += dungeon[row][col].bottomRowString();
				
				
			}
			result += "\r\n";
				
		}
		
		
		
		return result;
	
	}


	
	//for quick testing of functionality in this class
	public static void main(String [] args)
	{
		int maxRow = 5, maxCol = 5;
		Room r = new Room(0, 0, maxRow, maxCol);
		System.out.println(r);
		
		Room [][] dungeon = new Room[maxRow][maxCol];
		for (int row = 0; row < dungeon.length; row++)
			for (int col = 0; col < dungeon[row].length; col++)
				dungeon[row][col] = new Room(row, col, maxRow , maxCol);
	
		System.out.println(r.toStringDungeon(dungeon));
	}//end main
}//end class Room
