package Logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import Classes.Adventurer;
import Enemies.Enemies;
import GUI.gui;
import Items.Item;
import Map.Room;

public class GameLogic {
	private Adventurer player;
	private Map<Integer, Room> rooms;
	private Map<String, Enemies> enemiesList;
	private Map<String, Item> itemList;
	private boolean isRunning;
	private Parser parser;
	private gui gameGUI;

	public GameLogic() throws FileNotFoundException {
		this.isRunning = true;
		enemiesList = new HashMap<>();
		itemList = new HashMap<>();
		rooms = new HashMap<>();
		gameGUI = new gui(this);
		this.parser = new Parser();
	}

	public void startGame() throws FileNotFoundException {
	
		// Initialize player, rooms, items, etc.
		setupEnemies();
		setupItems();
		setupWorld();
		setupPlayer();
	}

	public void processInput(String input) {
		Command command = parser.parseCommand(input);
		command.execute(player, this);
		update();
	}

	private void update() {
		// Handle game updates like checking win/lose conditions
		if (player.hasWon() || player.isDead()) {
			isRunning = false;
		}
	}

	public void endGame() {
		isRunning = false;
	}

	private void setupWorld() throws FileNotFoundException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Story_Test_V6.csv");

		if (inputStream == null) {
			throw new FileNotFoundException("Resource file not found in the resources folder.");
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;

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
			    
				int roomName = Integer.parseInt(roomData[0].trim());
				String description = roomData[1].trim();
				char[] roomExits = roomData[2].trim().toCharArray();
				String[] roomItems = roomData[3].trim().split(";");
				String[] roomEnemies = roomData[4].trim().split(";");

				
				// Create Room object
				Room room = new Room(roomName, description, roomExits);
				for (String id: roomItems) {
					room.addItem(itemList.get(id));
				}
				
				for (String id: roomEnemies) {
					room.addEnemy(enemiesList.get(id));
				}

				// Add room to the map by name (if you need quick access by name)
				rooms.put(roomName, room);
			}


			// The last room doesn't have any further exits, so no need to link it
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setupPlayer() {

		System.out.println("Welcome to the game! Let's create your character.");
		String name = gameGUI.requestAnswer("Enter your character's name: ").join();

		while (true) {
			int intRace = Integer.parseInt(gameGUI.requestAnswer("Choose a race:\n1. Dwarf\n2. Elf\n3. Human").join());
			String race;
			switch(intRace) {
				case 1:
					race = "dwarf";
					break;
				case 2:
					race = "elf";
					break;
				case 3:
					race = "human";
					break;
				default:
					continue;
			}
			

			int intClass = Integer.parseInt(gameGUI.requestAnswer("Choose a Class:\n1. Fighter\n2. Mage\n3. Rogue").join());
			String job;
			switch(intClass) {
				case 1:
					job = "fighter";
					break;
				case 2:
					job = "mage";
					break;
				case 3:
					job = "rogue";
					break;
				default:
					continue;
			}

			System.out.println("Allocate stats for your character...5 available points.");
			int intAtk = Integer.parseInt(gameGUI.requestAnswer("How much Atk: ").join());
			int intDef = Integer.parseInt(gameGUI.requestAnswer("How much Def: ").join());
			int intSpd = Integer.parseInt(gameGUI.requestAnswer("How much Spd: ").join());
			
			player = new Adventurer(name, job, race, intAtk, intSpd, intDef, 10, 50, 0);
			break; // Exit loop after valid choice
		}

		System.out.println("Character created! Welcome, " + name + " the " + player.getRace() + player.getJob() + ".");

		// Start game with the player in the initial room (e.g., "StartRoom")
		player.setCurrentRoom(rooms.get(1));
		System.out.println(player.getCurrentRoom().getDescription());
		gameGUI.update();
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
				
				// Add enemy to list
				Enemies enemy = new Enemies(line.split(","));
				enemiesList.put(enemy.getUid(), enemy);
			}
		}catch(Exception e) {
				e.printStackTrace();
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
				itemList.put(item.getUid(), item);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}

	public Map<Integer, Room> getRooms() {
		return rooms;
	}

	public Adventurer getPlayer() {
		return player;
	}

	public static void main(String[] args) throws FileNotFoundException {
		GameLogic game = new GameLogic();
		game.startGame();

	}
}
