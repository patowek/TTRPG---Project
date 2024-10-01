package Logic;

import Classes.Adventurer;

public class CommandHelp extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		if (target.isBlank()) {
			System.out.println("List of Commands available:\nAttack\nExamine\nMove\nTake\nSkill\nUse\nExit\n" +
				"For More information on a command, type 'Help' and then the command you want more information on.");
		} else {
			String text = "Invalid text. Please review the command and try again.";
			switch (target.toLowerCase()) {
				case "attack":
					text = "Attack <target>. Causes the player to start combat, focusing on the enemy specified by replacing <target> with their name.";
					break;
				case "examine":
					text = "Examine <item>. Allows player to get a description on a specified item, or if no target is specified, gives a description of the room player is in.";
					break;
				case "move": 
					text = "Move <direction>. Allows player to move to another room in the direction specified, either North, East, South, or West.\n" + 
					"There must be an exit in that direction that isn't blocked.";
					break;
				case "take":
					text = "Take <item>. Picks up an specified item. Items locked in chests are unavailable until unlocked.";
					break;
				case "drop":
					text = "Drop <item>. Allows the player to drop an item from their inventory. Useful when inventory is full.";
					break;
				case "use":
					text = "Use <item>. Allows a player to use an item in their inventory. All useable items are one time use.";
					break;
				case "equip":
					text = "Equip <item>. Allows a player to equip an item from their inventory. Using equipment will allow the player to equip it for a boost while wearing.";
					break;
				case "unequip":
					text = "Unequip <item>. Unequips an item and places it in their inventory. Only useful when equipping more powerful equipment.";
					break;
				case "exit":
					text = "Exit. Quit the game. No saves, only restarts.";
					break;
			} 
			
			System.out.println(text);
				
		}

	}

}
