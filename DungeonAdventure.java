import java.io.*;
import java.util.Scanner;

public class DungeonAdventure {

	private static final String mainMenu = "\t***** Dungeon Adventure *****\n" + 
										"1) New Game\t	2) Load Save\n" +
										"0) Exit\n~> ";

	public static void main(String[] args) {
		Game game;
		Menu mm = new Menu("***** Dungeon Adventure *****", "New Game", "Load Save", "Exit");
		int menuChoice = mm.getSelection();
		switch (menuChoice) {
			case 0:
				game = newGame();
				break;
			case 1:
				game = loadGame();
				break;
			case 2:
				game = null;
			default:
				game = null;
				break;
		}
		if (game != null) {
			game.start();
		}
		System.out.println("Come again soon!");
	}

	private static int printMainMenu() {
		Scanner kb = new Scanner(System.in);
		System.out.print(mainMenu);
		return Integer.parseInt(kb.nextLine());
	}

	private static Game loadGame() {
		return loadGame("last_saved");
	}

	private static Game loadGame(String saveName) {
		Game gme = null;
		try {
			File fin = new File(System.getProperty("user.dir") + "/saves/" + saveName + ".dga");
			if (!fin.exists()) {
				System.out.println("Save " + saveName + " does not exist");
			} else {
				FileInputStream FisIn = new FileInputStream(fin);
				ObjectInputStream gameIn = new ObjectInputStream(FisIn);
				gme = (Game)gameIn.readObject();
				gameIn.close();
				FisIn.close();
			}
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
		return new Game();
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