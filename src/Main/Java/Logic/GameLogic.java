package Main.Java.Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Main.Java.Classes.Adventurer;
import Main.Java.Map.Room;
import Main.Java.Races.Dwarf;
import Main.Java.Races.Elf;
import Main.Java.Races.Human;

public class GameLogic {
	private Adventurer player;
	private Map<String, Room> rooms;
	private boolean isRunning;
	private Parser parser;

	public GameLogic() {
		this.isRunning = true;
		this.parser = new Parser();
		rooms = new HashMap<>();
	}

	public void startGame() throws FileNotFoundException {
		// Initialize player, rooms, items, etc.
		setupWorld();
		while (isRunning) {
			System.out.println("What would you like to do?");
			String input = getUserInput();
			processInput(input);
			update();
		}
		endGame();
	}

	private void processInput(String input) {
		Command command = parser.parseCommand(input);
		command.execute(player, this);
	}

	private void update() {
		// Handle game updates like checking win/lose conditions
//        if (player.hasWon() || player.isDead()) {
//            isRunning = false;
//        }
	}

	private String getUserInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void endGame() {
		System.out.println("Thanks for playing!");
	}

	private void setupWorld() throws FileNotFoundException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Story_Test_V1.csv");

		if (inputStream == null) {
			throw new FileNotFoundException("Resource file not found in the resources folder.");
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			List<Room> roomList = new ArrayList<>(); // List to store rooms in sequence

			// Read rooms from the CSV and create Room objects
			while ((line = br.readLine()) != null) {
				String[] roomData = line.split(",");
				String roomName = roomData[0];
				String description = roomData[1];
				// Create Room object
				Room room = new Room(roomName, description);

				// Add room to the list
				roomList.add(room);

				// Add room to the map by name (if you need quick access by name)
				rooms.put(roomName, room);
			}

			// Now link each room to the next one using the list
			for (int i = 0; i < roomList.size() - 1; i++) {
				Room currentRoom = roomList.get(i);
				Room nextRoom = roomList.get(i + 1);
				currentRoom.addExit("Next Room", nextRoom); // Only one exit leading to the next room
			}

			// The last room doesn't have any further exits, so no need to link it
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Ask questions to create a character
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the game! Let's create your character.");
		System.out.print("Enter your character's name: ");
		String name = scanner.nextLine();

		while (true) {
			System.out.print("Choose a race (e.g., Dwarf, Elf, Human): ");
			String characterClass = scanner.nextLine().toLowerCase();

			System.out.println("Allocating stats for your character...");

			// Initialize player based on the race choice
			switch (characterClass) {
			case "dwarf":
				player = new Dwarf(name, 10, 10, 10, 10, 10, 10, 1, 10, 10);
				break;
			case "elf":
				player = new Elf(name, 10, 10, 10, 10, 10, 10, 1, 10, 10);
				break;
			case "human":
				player = new Human(name, 10, 10, 10, 10, 10, 10, 1, 10, 10);
				break;
			default:
				System.out.println("Invalid race. Please choose again.");
				continue; // Loop again if invalid choice
			}
			break; // Exit loop after valid choice
		}

		System.out.println("Character created! Welcome, " + name + " the " + player.getClass().getSimpleName() + ".");

		// Start game with the player in the initial room (e.g., "StartRoom")
		player.setCurrentRoom(rooms.get("StartRoom"));
	}

	public static void main(String[] args) throws FileNotFoundException {
		GameLogic game = new GameLogic();
		game.startGame();
	}
}
