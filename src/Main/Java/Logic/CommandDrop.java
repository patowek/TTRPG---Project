package Logic;

import Classes.Adventurer;
import Items.Item;
import Map.Room;

public class CommandDrop extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Item targetItem = null;
		Item[] inventory = player.getItems();
		int itemSlot = 0;
		for (Item item: inventory) {
			if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
				break;
			}
			itemSlot++;
		}
		
		if (targetItem != null) {
			player.setItems(itemSlot, null);
			currentRoom.addItem(targetItem);
			System.out.println("You drop the " + target + "\n");
		} else {
			System.out.println("There's no " + target + " in your inventory.\n");
		}

	}

}
