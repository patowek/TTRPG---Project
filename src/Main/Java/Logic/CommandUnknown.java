package Logic;

import Classes.Adventurer;

public class CommandUnknown extends Command {
	@Override
	public void execute(Adventurer player, GameLogic game) {
		System.out.println("I don't understand that command.");
	}

}
