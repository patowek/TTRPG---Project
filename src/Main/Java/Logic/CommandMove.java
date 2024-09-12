package Logic;

import Classes.Adventurer;
import Map.Room;

public class CommandMove extends Command {
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room nextRoom = player.getCurrentRoom().getExit(target);
		if (nextRoom != null) {
			player.setCurrentRoom(nextRoom);
			System.out.println("You move " + target + " to " + nextRoom.getDescription());
		} else {
			System.out.println("You can't go that way!");
		}
	}
}