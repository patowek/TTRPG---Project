package Logic;

import Classes.Adventurer;
import Items.Item;

public class CommandEquip extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Item targetItem = null;
		Item[] inventory = player.getItems();
		int itemSlot = 0;
		int targetSlot = 5;
		boolean equipmentSlotTaken = true;
		for (Item item: inventory) {
			if (item.getName() == target) {
				targetItem = item;
				targetSlot = targetItem.getType();
				break;
			}
			itemSlot++;
		}
		
		if (player.getGear(targetSlot) == null && targetSlot < 5)
			equipmentSlotTaken = false;
		
		if (targetItem != null && targetSlot < 5 && equipmentSlotTaken == false) {			
			player.setItems(itemSlot, null);
			player.setGear(targetSlot, targetItem);
			System.out.println("You equip the " + target);
		} else if (targetSlot == 5) {
			System.out.println("Invalid equipment type. Try again.");
		} else if (equipmentSlotTaken == true) {
			System.out.println("Equipment slot taken. Please unequip first.");
		} else {
			System.out.println("There's no " + target + " in your inventory.");
		}

	}

}
