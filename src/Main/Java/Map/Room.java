package Main.Java.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Main.Java.Enemies.Enemies;
import Main.Java.Items.Item;

public class Room {
    private String name;                   // Room name or description
    private String description;            // More detailed description of the room
    private Map<String, Room> exits;       // Available exits, mapping direction to Room
    private List<Item> items;              // Items present in the room
    private List<Enemies> enemies;           // Enemies present in the room

    // Constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    // Method to add an exit to the room
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    // Method to get an exit based on direction
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    // Method to add an item to the room
    public void addItem(Item item) {
        items.add(item);
    }

    // Method to remove an item from the room
    public void removeItem(Item item) {
        items.remove(item);
    }

    // Method to add an enemy to the room
    public void addEnemy(Enemies enemy) {
        enemies.add(enemy);
    }

    // Method to remove an enemy from the room
    public void removeEnemy(Enemies enemy) {
        enemies.remove(enemy);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Item> getItems() {
        return items;
    }

    public List<Enemies> getEnemies() {
        return enemies;
    }
}
