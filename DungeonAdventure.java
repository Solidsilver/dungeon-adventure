import java.io.*;

public class DungeonAdventure {
	private Game game;

	public static void main(String[] args) {

	}

	private static Game loadGame() {
		return loadGame("last_saved");
	}

	private static Game loadGame(String saveName) {
		Game gme = null;
		try {
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir") + "/saves/" + saveName);
			ObjectInputStream gameIn = new ObjectInputStream(fin);
			gme = (Game) gameIn.readObject();
			gameIn.close();
			fin.close();
		} catch (IOException i) {
			System.out.println("Error reading file");
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Game class not found");
			c.printStackTrace();
		}

		return gme;
	}

	private static Game newGame() {
		return null;
	}

	public static void saveGame(Game gme) {
		saveGame(gme, "last_saved");
	}

	private static void saveGame(Game gme, String saveName) {
		try {
			FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir") + "/saves/" + saveName + ".dga");
			ObjectOutputStream saveOut = new ObjectOutputStream(fout);
			saveOut.writeObject(gme);
			saveOut.close();
			fout.close();
			System.out.println("Game Saved");
		} catch (IOException i) {
			System.out.println("Error saving game");
			i.printStackTrace();
		}

	}

	private static void startGame(Game gme) {

	}

}