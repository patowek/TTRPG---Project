package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enemies.Enemies;
import Items.Item;

public class Room {
	private String name; // Room name or description
	private String description; // More detailed description of the room
	private Map<String, String> exits; // Available exits, mapping direction to Room
	private Map<String, Item> items; // Items present in the room
	private Map<String, Enemies> enemies; // Enemies present in the room
	private boolean visited = false;

	// Constructor
	public Room(String name, String description, char[] exits) {
		this.name = name;
		this.description = description;
		this.exits = new HashMap<>();
		this.items = new HashMap<>();
		this.enemies = new HashMap<>();
		
		addExit(exits);
	}

	// Method to add an exit to the room
	public void addExit(char[] exitArray) {
		exits.put("north", String.valueOf(exitArray[0]));
		exits.put("east", String.valueOf(exitArray[1]));
		exits.put("south", String.valueOf(exitArray[2]));
		exits.put("west", String.valueOf(exitArray[3]));
	}

	// Method to get an exit based on direction
	public Room getExit(String direction, Map<String, Room> roomList) {
		return roomList.get(exits.get(direction));
	}

	// Method to add an item to the room
	public void addItem(Item item) {
		items.put(item.getUid(), item);
	}

	// Method to remove an item from the room
	public boolean removeItem(Item item) {
		return items.remove(item.getUid(), item);
	}

	// Method to add an enemy to the room
	public void addEnemy(Enemies enemy) {
		enemies.put(enemy.getUid(), enemy);
	}

	// Method to remove an enemy from the room
	public boolean removeEnemy(Enemies enemy) {
		return enemies.remove(enemy.getUid(), enemy);
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Item> getItems() {
		return new ArrayList<>(items.values());
	}
	
	public Item getItem(String uid) {
		return items.get(uid);
	}

	public List<Enemies> getEnemies() {
		return new ArrayList<>(enemies.values());
	}

	/**
	 * @return the hasVisited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param hasVisited the hasVisited to set
	 */
	public void setVisited(boolean hasVisited) {
		this.visited = hasVisited;
	}
}
