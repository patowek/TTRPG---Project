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
		Item[] inventory = player.getItems();
		int freeSlot = 0;
		for (Item item: inventory) {
			if (item != null)
				freeSlot++;
				continue;
			
		}
		
		if (freeSlot < 8) {
			System.out.println("No available space in inventory, please drop/use an item first.");
		}
		
		for (Item item: items) {
			if (item.getName() == target) {
				targetItem = item;
			}
		}
		
		if (targetItem != null) {
			player.setItems(freeSlot, targetItem);
			currentRoom.removeItem(targetItem);
			System.out.println("You take the " + target);
		} else {
			System.out.println("There's no " + target + " here.");
		}
	}
}
