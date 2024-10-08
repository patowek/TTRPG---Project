package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enemies.Enemies;
import Items.Item;

public class Room {
	private int name; // Room name or description
	private String description; // More detailed description of the room
	private Map<Directions, Integer> exits; // Available exits, mapping direction to Room
	private Map<String, Item> items; // Items present in the room
	private Map<String, Enemies> enemies; // Enemies present in the room
	private boolean visited = false;
	
	// Constructor
	public Room(int name, String description, char[] exits) {
		this.name = name;
		this.description = description;
		this.exits = new HashMap<>();
		this.items = new HashMap<>();
		this.enemies = new HashMap<>();
		
		addExit(exits);
	}

	// Method to add an exit to the room
	public void addExit(char[] exitArray) {
		exits.put(Directions.NORTH, Integer.parseInt(String.valueOf(exitArray[0])));
		exits.put(Directions.EAST, Integer.parseInt(String.valueOf(exitArray[1])));
		exits.put(Directions.SOUTH, Integer.parseInt(String.valueOf(exitArray[2])));
		exits.put(Directions.WEST, Integer.parseInt(String.valueOf(exitArray[3])));
	}

	// Method to get an exit based on direction
	public Room getExit(String direction, Map<Integer, Room> map) {
		Directions way = Directions.fromString(direction);		
		return map.get(exits.get(way));
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
	public int getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Item> getItems() {
		return new ArrayList<>(items.values());
	}
	
	public List<Directions> getExits() {
		List<Directions> availableExits = new ArrayList<>();
		
		for (Map.Entry<Directions, Integer> entry : exits.entrySet()) {
	        if (entry.getValue() > 0) {
	            availableExits.add(entry.getKey());
	        }
	    }
		
		return availableExits;
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
