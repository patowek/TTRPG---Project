package Logic;

import Classes.Adventurer;
import Items.Item;

public class CommandUnequip extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Item targetItem = null;
		Item[] loadout = player.getGear();
		int targetSlot = 5;
		Item[] inventory = player.getItems();
		int freeSlot = 0;
		for (Item item: inventory) {
			if (item != null)
				freeSlot++;
				continue;
			
		}
		
		for (Item item: loadout) {
			if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
				targetSlot = targetItem.getType();
				break;
			}
		}
		
		if (targetItem != null && freeSlot < 8) {			
			player.setItems(freeSlot, targetItem);
			player.setGear(targetSlot, null);
			System.out.println("You unequip the " + target);
		} else if (freeSlot > 7) {
			System.out.println("No available space in inventory, please drop/use an item first.");
		} else {
			System.out.println("There's no " + target + " in your inventory.");
		}

	}

}
