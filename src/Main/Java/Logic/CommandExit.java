package Logic;

import Classes.Adventurer;

public class CommandExit extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		game.endGame();
	}

}
