package Logic;

import java.util.List;

import Classes.Adventurer;
import Items.Item;
import Map.Room;

public class CommandExamine extends Command {
	
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Item item = findItem(currentRoom, player, target);
		if (target.isBlank()) {
			System.out.println(currentRoom.getDescription());
		} else if (!item.equals(null)) {
			System.out.println(item.toString());
		} else {
			System.out.println("No such item found. Try again.");
		}
		
	}
	
	private static Item findItem(Room currentRoom, Adventurer player, String target) {
		Item result = null;
		
		List<Item> roomList = currentRoom.getItems();
		for (Item item: roomList) {
			if (item.getName().equals(target)) {
				return item;		
			}
		}
		
		List<Item> playerList = player.getItems();
		
		for (Item item: playerList) {
			if (item.getName().equals(target)) {
				return item;		
			}
		}
		return result;

	}

}