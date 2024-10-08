package Logic;

import java.util.List;

import Classes.Adventurer;
import Items.Item;

public class CommandUnequip extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Item targetItem = null;
		Item[] loadout = player.getGear();
		int targetSlot = 5;
		List<Item> inventory = player.getItems();
		int freeSlot = inventory.size();

		
		for (Item item: loadout) {
			if (item == null) {
				continue;
			} else if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
				targetSlot = targetItem.getType();
				break;
			} else {
				continue;
			}
		}
		
		if (targetItem != null && freeSlot < 8) {			
			player.addItem(targetItem);
			player.setGear(targetSlot, null);
			System.out.println("You unequip the " + target + "\n");
		} else if (freeSlot > 7) {
			System.out.println("No available space in inventory, please drop/use an item first.\n");
		} else {
			System.out.println("There's no " + target + " in your inventory.\n");
		}

	}

}
