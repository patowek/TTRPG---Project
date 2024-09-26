package Logic;

import Classes.Adventurer;
import Classes.Attributes;
import Items.Item;

public class CommandUseItem extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Item targetItem = null;
		Item[] inventory = player.getItems();
		int itemSlot = 0;
		for (Item item: inventory) {
			if (item.getName() == target) {
				targetItem = item;
				break;
			}
			itemSlot++;
		}
		
		if (targetItem != null) {
			player.setItems(itemSlot, null);
			String[] stat = targetItem.getStat();
			int value = player.getStat(Attributes.valueOf(stat[0]));
			player.setStat(Attributes.valueOf(stat[0]), value + Integer.parseInt(stat[2]));
			System.out.println("You use the " + target);
		} else {
			System.out.println("There's no " + target + " in your inventory.");
		}

	}

}
