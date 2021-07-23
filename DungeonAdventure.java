/**
 * @author Luke Mattfeld
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import utils.*;


public class DungeonAdventure {
	public static void main(String[] args) {
		checkSaveDir();
		Game game = null;
		int menuChoice = -1;
		Menu mm = new Menu("***** Dungeon Adventure *****", "New Game", "Resume Game", "How to Play", "About", "Exit");
		do {
			Menu.clearScreen();
			menuChoice = mm.getSelection(2, false);
			switch (menuChoice) {
			case 0:
				game = newGame();
				break;
			case 1:
				if (getSaveList().contains("last_saved")) {
					game = loadGameDefault();
				} else {
					System.out.println("No game to resume. Starting a new game...");
					game = newGame();
				}
				break;
			case 2:
				howToPlay();
				game = null;
				break;
			case 3:
				about();
				game = null;
				break;
			case 4:
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

	private static void about() {
		Menu.clearScreen();
		System.out.print("Creators:\n"
						+ "- Jeff Howes\n"
						+ "- Andrew Sales\n"
						+ "- Luke Mattfeld\n"
						+ "Dungeon Adventure was created as a project for CSCD349\n"
						+ "at Eastern Washington University. The goal was to make use\n"
						+ "of Design Patterns to make the game more easily extensible,\n"
						+ "buildable in parts, and intent revieling.\n\n"
						+ "(press any key to continue)");
		new Scanner(System.in).nextLine();
		System.out.println();
	}

	private static void howToPlay() {
		Menu.clearScreen();
		System.out.print("Welcome to Dungeon Adventure!\n"
							+ "Your characther finds themselves locked in an old Dungeon.\n"
							+ "The only way to escape is to find the legendary Pillars of Object Oriented Programming...\n\n"
							+ "Begin starting a new game, and choosing a character.\n"
							+ "Every character has different attributes and attack styles.\n"
							+ "You will then need to navigate through rooms of the Dungeon:\n"
							+ "Rooms can contain Pits, Monsters, magic potions, and treasure.\n"
							+ "If you encounter a monster in a room, you must fight it.\n"
							+ "Vision potions allow you to see what's around you.\n"
							+ "Healing potions give you strength to continue.\n"
							+ "Throughout the Dungeon are scattered the 4 pillars of OO.\n"
							+ "You must find all of them and make it to the exit to win..\n"
							+ "You may save the game at any time, and when you restart the game, just select 'Resume Game'.\n"
							+ "Have fun!\n\n"
							+ "(pressy any key to continue)");
		new Scanner(System.in).nextLine();
		System.out.println();
	}

	private static void checkSaveDir() {
		File saveDir = new File(System.getProperty("user.dir") + "/saves");
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
	}

	private static Game loadGame() {
		ArrayList<String> saves = getSaveList();
		Menu mnu = new Menu("Saves", saves);
		mnu.add("Back");
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
			if (fin == null || !fin.exists()) {
				System.out.println("Save " + saveName + " does not exist, please load new game");
			} else {
				FileInputStream FisIn = new FileInputStream(fin);
				ObjectInputStream gameIn = new ObjectInputStream(FisIn);
				gme = (Game) gameIn.readObject();
				gameIn.close();
				FisIn.close();
			}
		} catch (IOException i) {
			System.out.println("Error reading file. Please start a new game.");
			//i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Game class not found");
			//c.printStackTrace();
		}
		return gme;
	}

	private static Game loadGameDefault() {
		return loadGame("last_saved");
	}

	private static ArrayList<String> getSaveList() {
		checkSaveDir();
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
			//i.printStackTrace();
		}

	}

	public static void saveGameDefault(Game game) {
		saveGame(game, "last_saved");
	}

}