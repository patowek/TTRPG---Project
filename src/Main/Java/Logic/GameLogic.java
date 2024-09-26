package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Classes.Adventurer;
import Enemies.Enemies;
import Items.Item;
import Map.Room;
import Races.*;

public class GameLogic {
	private Adventurer player;
	private Map<String, Room> rooms;
	private Map<String, Enemies> enemiesList = new HashMap<>();
	private Map<String, Item> itemList = new HashMap<>();
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
		System.out.println("Thanks for playing!");
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
		isRunning = false;
	}

	private void setupWorld() throws FileNotFoundException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Story_Test_V5.csv");

		if (inputStream == null) {
			throw new FileNotFoundException("Resource file not found in the resources folder.");
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			List<Room> roomList = new ArrayList<>(); // List to store rooms in sequence

			br.readLine();
			
			// Read rooms from the CSV and create Room objects
			while ((line = br.readLine()) != null) {
			    // Check if the line is not empty
			    if (line.trim().isEmpty()) {
			        continue;  // Skip empty lines
			    }
				
			    // Split the line and check if there are enough parts
			    String[] roomData = line.split(",");
			    if (roomData.length < 2) {
			        System.err.println("Skipping invalid line: " + line);
			        continue;  // Skip lines that don't have enough data
			    }
			    
				String roomName = roomData[0].trim();
				String description = roomData[1].trim();
				
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
		System.out.println(player.getCurrentRoom().getDescription());
	}
	
	private void setupEnemies() throws FileNotFoundException{
		String line;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("enemies.csv");
		
		if(inputStream == null) {
			throw new FileNotFoundException("Resource file not found in the resource folder.");
		}

		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
			// Skip header line
			br.readLine();
			
			// Loop through each line
			while((line = br.readLine())!=null){
				if(line.trim().isEmpty()) {
					continue;
				}	
				String[] enemyInfo = line.split(",");// Comma separator
				// Parse stats and create enemy objects
				String name = enemyInfo[0].trim();
				String hitpoints = enemyInfo[1].trim();
				String armor = enemyInfo[2].trim();
				String speed = enemyInfo[3].trim();
				String challengeRating = enemyInfo[4].trim();
				
				// Add enemy to list
				Enemies enemy = new Enemies(name, hitpoints, armor, speed, challengeRating);
				enemiesList.put(enemy.getName(), enemy);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
			// Print all enemies
			for(Enemies enemy : enemiesList) {
				System.out.println(enemy.getArmor());
			}
		}
	
	private void setupItems() throws FileNotFoundException{
		String line;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("item.csv");
		
		if(inputStream == null) {
			throw new FileNotFoundException("Resource file not found in the resource folder.");
		}

		try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))){
			// Skip header line
			br.readLine();
			
			// Loop through each line
			while((line = br.readLine())!=null){
				if(line.trim().isEmpty()) {
					continue;
				}	
				
				// Add enemy to list
				Item item = new Item(line.split(","));
				itemList.add(item);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
			// Print all enemies
			for(Item item : itemList) {
				System.out.println(item);
			}
		}

	public static void main(String[] args) throws FileNotFoundException {
		GameLogic game = new GameLogic();
		game.setupWorld();
		game.startGame();
//		game.setupEnemies();
//		game.setupItems();
	}
}
