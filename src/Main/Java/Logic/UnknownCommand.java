package Main.Java.Logic;

import Main.Java.Classes.Adventurer;

public class UnknownCommand extends Command {
	@Override
	public void execute(Adventurer player, GameLogic game) {
		System.out.println("I don't understand that command.");
	}

}
