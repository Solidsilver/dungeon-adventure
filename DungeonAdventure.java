/**
 * @author Luke Mattfeld
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import utils.*;

/***
 * 
 * CSCD 327 Design Patterns – Final homework project -  Team member contributions

Andrew Sales worked on:  
•	HeroFactory
•	MonsterFactory
•	Attack package
	o	IAttack interface
	o	Attack class
	o	CrushingBlow class
	o	IncreaseHitPoint class
•	Character.heros Package
	o	Hero Interface
	o	HeroFactory class
	o	Sorceress class
	o	StuTheSteiner class
	o	TomTheCapaul class
	o	Warrior class
•	Character.monsters
	o	Monster interface
	o	MonsterFactory class
	o	BrianTheCamp class
	o	ChristhePeter class
	o	Gremlin class
	o	Ogre class
	o	Skeleton class
•	UML objects for the above items
•	Worked on merging all UML objects into one file.
•	Game testing

Jeff Howes worked on:
•	Dungeon.room package
	o	Room class
	o	RoomFactory class
•	DungeonFactory class
•	Print class 
•	Worked on Base code.
•	UML objects for the above items
•	Worked on merging all UML objects into one file.
•	Worked on managing project requirements were meet by the team.
•	Worked on implementing HealingPotion class, PickedupItem class, Pillar class, VisionPostion class.
•	Bug tracking
•	Game testing
•	Team member contributions tracking
•	HW project’s Package construction

Luke Mattfeld worked on:
•	Git hub usage support for the team.
•	High level package structure
•	DungeonAdventer Class
•	PlayerController class. 
•	Game Class
•	Dungeon Class
•	User Menu class
•	PickupItem Interface
•	Worked on implementing HealingPotion class, PickedupItem class, Pillar class, VisionPostion class.
•	Game testing
•	Bug fixing
 *
 */

public class DungeonAdventure {
	public static void main(String[] args) {
		checkSaveDir();
		Game game = null;
		int menuChoice = -1;
		Menu mm = new Menu("***** Dungeon Adventure *****", "New Game", "Resume Game", "Exit");
		do {
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
			/*case 2:
				game = loadGame();
				break;
				*/
			case 2:
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