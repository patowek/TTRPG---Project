package Logic;

import java.util.List;

import Classes.Adventurer;
import Enemies.Enemies;
import Items.Item;
import Map.Directions;
import Map.Room;

public class CommandExamine extends Command {
	
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		if (target.isBlank()) {
			StringBuilder situation = new StringBuilder("You see the following: \n\n");
			List<Item> roomItems = currentRoom.getItems();
			for (Item item: roomItems)
				situation.append("    " + item.getName() + "\n");
			List<Enemies> roomEnemies = currentRoom.getEnemies();
			for (Enemies enemy: roomEnemies)
				situation.append("    " + enemy.getName() + "\n");
			System.out.println(situation);
		} else if (target.equalsIgnoreCase("exits")) {
			StringBuilder situation = new StringBuilder("You see the following exits: \n\n");
			List<Directions> roomExits = currentRoom.getExits();
			for (Directions dir : roomExits) {
				situation.append("    " + dir.getName() + "\n");
			}
			System.out.println(situation);
		} else {
			Item item = findItem(currentRoom, player, target);
			if (!item.equals(null)) {
				System.out.println(item.toString());
			} else {
				System.out.println("No such item found. Try again.");
			}
		}
	}
	
	private Item findItem(Room currentRoom, Adventurer player, String target) {
		if (target == null || target.isEmpty()) {
	        return null; // Handle invalid target
	    }
		
		// Look for the item in the room
	    List<Item> roomList = currentRoom.getItems();
	    if (roomList != null) {
	        for (Item item : roomList) {
	            if (item.getName().equalsIgnoreCase(target)) {
	                return item;  // Return if found in the room
	            }
	        }
	    }
		
	 // Look for the item in the player's inventory
	    Item[] playerArray = player.getItems();
	    if (playerArray != null) {
	        for (Item item : playerArray) {
	            if (item.getName().equalsIgnoreCase(target)) {
	                return item;  // Return if found in player's inventory
	            }
	        }
	    }
	    
		return null;

	}

}