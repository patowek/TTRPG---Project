package Logic;

import java.util.List;

import Classes.Adventurer;
import Classes.Attributes;
import Items.Item;

public class CommandUseItem extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Item targetItem = null;
		List<Item> inventory = player.getItems();
		int itemType = 0;
		for (Item item: inventory) {
			if (item.getName().equalsIgnoreCase(target)) {
				targetItem = item;
				itemType = targetItem.getType();
				break;
			}
		}
		
		if (targetItem != null && itemType == 5) {
			player.removeItem(targetItem);
			String[] stat = targetItem.getStat();
			int value = Integer.parseInt(stat[2]);
			value = stat[1].equals("-") ? -value : value;
			player.modifyStat(Attributes.valueOf(stat[0]), value);
			System.out.println("You use the " + target + "\n");
		} else if (itemType != 5) {
			System.out.println("You are trying to use the wrong type of item. Try command 'Equip' or try a different item.\n");
		} else {
			System.out.println("There's no " + target + " in your inventory.\n");
		}

	}

}
