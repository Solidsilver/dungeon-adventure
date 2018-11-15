import java.util.Random;

public class Dungeon
{
	private Room [][] dungeon;
	private int entranceRow, entranceCol;
	private int exitRow, exitCol;
	private int crownRow1, crownCol1;
	private int crownRow2, crownCol2;
	
	public Dungeon(int rows, int cols)
	{
		this.dungeon = new Room[rows][cols];
		for (int row = 0; row < this.dungeon.length; row++)
			for (int col = 0; col < this.dungeon[row].length; col++)
				this.dungeon[row][col] = new Room(row, col, rows, cols);
				
		setEntrance();
		setExit();
		setCrownPiece1();
		setCrownPiece2();
	
	
	}//end constructor
	
	private void setEntrance()
	{
		Random r = new Random();
				
		this.entranceRow = r.nextInt(this.dungeon.length);
		this.entranceCol = r.nextInt(this.dungeon[0].length);
		
		this.dungeon[this.entranceRow][this.entranceCol].setEntrance();
		
		
	}
		
	private void setExit()
	{
		Random r = new Random();
		
		do
		{
			this.exitRow = r.nextInt(this.dungeon.length);
			this.exitCol = r.nextInt(this.dungeon[0].length);
			
		} while (this.exitRow == this.entranceRow && this.exitCol == this.entranceCol);
		
		this.dungeon[this.exitRow][this.exitCol].setExit();
	}
	
	private void setCrownPiece1()
	{
		Random r = new Random();
		
		do
		{
			this.crownRow1 = r.nextInt(this.dungeon.length);
			this.crownCol1 = r.nextInt(this.dungeon[0].length);
		
		} while (this.crownRow1 == this.entranceRow && this.crownCol1 == this.entranceCol
					|| this.crownRow1 == this.exitRow && this.crownCol1 == this.exitCol);
					
		this.dungeon[this.crownRow1][this.crownCol1].setCrown();
	
	}
	
	private void setCrownPiece2()
	{
		Random r = new Random();
		
		do
		{
			this.crownRow2 = r.nextInt(this.dungeon.length);
			this.crownCol2 = r.nextInt(this.dungeon[0].length);
		
		} while (this.crownRow2 == this.entranceRow && this.crownCol2 == this.entranceCol
					|| this.crownRow2 == this.exitRow && this.crownCol2 == this.exitCol
					|| this.crownRow1 == this.crownRow2 && this.crownCol1 == this.crownCol2);
					
		this.dungeon[this.crownRow2][this.crownCol2].setCrown();

	
	}
	
	public String toString()
	{
		String result = "";
		
		for (int row = 0; row < this.dungeon.length; row++)
		{
			if (row == 0)
			{
				for (int col = 0; col < this.dungeon[row].length; col++)
				{
					result += this.dungeon[row][col].topRowString();
					
					
				}
				result += "\r\n";
			}
			
			for (int col = 0; col < this.dungeon[row].length; col++)
			{
				result += this.dungeon[row][col].middleRowString();
				
				
			}
			result += "\r\n";
			
			for (int col = 0; col < this.dungeon[row].length; col++)
			{
				result += this.dungeon[row][col].bottomRowString();
				
				
			}
			result += "\r\n";
				
		}
		
		
		
		return result;
	
	}


	
	//testing
	public static void main(String [] args)
	{
		Dungeon mordor = new Dungeon(3, 3);
		System.out.println(mordor);
	
	}
}//end class Dungeon