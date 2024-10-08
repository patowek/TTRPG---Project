package Logic;

import java.util.List;

import Classes.Adventurer;
import Items.Item;
import Map.Room;

public class CommandDrop extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Item targetItem = null;
		List<Item> inventory = player.getItems();
		for (Item item: inventory) {
			if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
				break;
			}
		}
		
		if (targetItem != null) {
			player.removeItem(targetItem);
			currentRoom.addItem(targetItem);
			System.out.println("You drop the " + target + "\n");
		} else {
			System.out.println("There's no " + target + " in your inventory.\n");
		}

	}

}
