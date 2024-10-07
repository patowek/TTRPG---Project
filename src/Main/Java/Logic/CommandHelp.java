package Logic;

import Classes.Adventurer;

public class CommandHelp extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		if (target.isBlank()) {
			System.out.println("List of Commands available:\nAttack\nExamine\nMove\nTake\n\nUse\nExit\n" +
				"For More information on a command, type 'Help' and then the command you want more information on.");
		} else {
			String text = "Invalid text. Please review the command and try again.";
			switch (target.toLowerCase()) {
				case "attack":
					text = "Attack <target>. Causes the player to start combat, focusing on the enemy specified by replacing <target> with their name."
					+ "If combat has already started, this command will continue with another attack on the target.";
					break;
				case "flee":
					text = "flee. Allows the player to attempt to break from combat. If sucessful, the combat will be paused, otherwise the enemy will "
					+ "continue to attack after every action the player takes.";
					break;
				case "examine":
					text = "Examine <item> or exits. Allows player to get a description on a specified item, or if no target is specified, gives a list of items and enemies in the room."
					+ "If the target is exits, this command will list the possible exits within the room.";
					break;
				case "move": 
					text = "Move <direction>. Allows player to move to another room in the direction specified, either North, East, South, or West.\n" + 
					"All exits are blocked as long as there is an enemy present, with the exception of previously visited rooms.";
					break;
				case "take":
					text = "Take <item>. Picks up an specified item.";
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
