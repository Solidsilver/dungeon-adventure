import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DungeonAdventure {
	public static void main(String[] args) {
		Game game = null;
		int menuChoice = -1;
		Menu mm = new Menu("***** Dungeon Adventure *****", "New Game", "Resume Game", "Load Save", "Exit");
		do {
			menuChoice = mm.getSelection();
			switch (menuChoice) {
			case 0:
				game = newGame();
				break;
			case 1:
				if (getSaveList().contains("last_saved")) {
					game = loadGameDefault();
				} else {
					System.out.println("No game to resume");
				}
				break;
			case 2:
				game = loadGame();
				break;
			case 3:
				game = null;
				break;
			default:
				game = null;
			}
			if (game != null) {
				game.start();
			}
		} while (!mm.isLast(menuChoice));
		System.out.println("Come again soon!");
	}

	private static Game loadGame() {
		Scanner kb = new Scanner(System.in);
		ArrayList<String> saves = getSaveList();
		Menu mnu = new Menu("Saves", saves);
		mnu.addChoice("Back");
		int loadSave = mnu.getSelection(1);
		if (!mnu.isLast(loadSave)) {
			return loadGame(saves.get(loadSave));
		}
		return null;

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
				gme = (Game) gameIn.readObject();
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

	private static Game loadGameDefault() {
		return loadGame("last_saved");
	}

	private static ArrayList<String> getSaveList() {
		File fin = new File(System.getProperty("user.dir") + "/saves");
		ArrayList<String> saves = new ArrayList<>();
		for (String s : fin.list()) {
			saves.add(s.substring(0, s.length() - 4));
		}
		return saves;
	}

	private static Game newGame() {
		return new Game();
	}

	public static void saveGame(Game game) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Save game:\nSave name: ");
		saveGame(game, kb.nextLine());
	}

	private static void saveGame(Game game, String saveName) {
		try {
			FileOutputStream fout = new FileOutputStream(
					System.getProperty("user.dir") + "/saves/" + saveName + ".dga");
			ObjectOutputStream saveOut = new ObjectOutputStream(fout);
			saveOut.writeObject(game);
			saveOut.close();
			fout.close();
			System.out.println("Game Saved");
		} catch (IOException i) {
			System.out.println("Error saving game");
			i.printStackTrace();
		}

	}

	public static void saveGameDefault(Game game) {
		saveGame(game, "last_saved");
	}

	private static void startGame(Game gme) {

	}

}