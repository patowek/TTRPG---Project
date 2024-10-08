package Logic;

import java.util.List;

import Classes.Adventurer;
import Items.Item;
import Map.Room;

public class CommandTake extends Command {
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		List<Item> items = currentRoom.getItems();
		Item targetItem = null;
		List<Item> inventory = player.getItems();
		int freeSlot = inventory.size();
		
		if (freeSlot > 8) {
			System.out.println("No available space in inventory, please drop/use an item first.\n");
		}
		
		for (Item item: items) {
			if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
			}
		}
		
		if (targetItem != null) {
			player.addItem(targetItem);
			currentRoom.removeItem(targetItem);
			System.out.println("You take the " + target + "\n");
		} else {
			System.out.println("There's no " + target + " here.\n");
		}
	}
}
