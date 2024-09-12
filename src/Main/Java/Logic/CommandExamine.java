package Logic;

import Classes.Adventurer;
import Map.Room;

public class CommandExamine extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		System.out.println(currentRoom.getDescription());
	}

}