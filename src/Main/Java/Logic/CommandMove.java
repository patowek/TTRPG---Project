package Logic;

import Classes.Adventurer;
import Map.Room;

public class CommandMove extends Command {
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room room = player.getCurrentRoom();
		Room nextRoom = room.getExit(target, game.getRooms());
		boolean blocked = !room.getEnemies().isEmpty();
		
		if (blocked) {
			System.out.println("You can't go that way until the enemies are cleared.\n");
		} else if (nextRoom != null && (!blocked || nextRoom.isVisited())) {
			player.setCurrentRoom(nextRoom);
			System.out.println("You move " + target + ".\n" + nextRoom.getDescription() + "\n");
		} else {
			System.out.println("You can't go that way!\n");
		}
	}
}