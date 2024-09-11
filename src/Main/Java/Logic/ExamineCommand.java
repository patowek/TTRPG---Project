package Main.Java.Logic;

import Main.Java.Classes.Adventurer;
import Main.Java.Map.Room;

public class ExamineCommand extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		System.out.println(currentRoom.getDescription());
	}
	
}