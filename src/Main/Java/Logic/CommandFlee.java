package Logic;

import Classes.Adventurer;

public class CommandFlee extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Combat fight = game.getActiveCombat();
		
		if (fight != null) {
			
			fight.fleeAction();
		} else {
			System.out.println("Player is not in combat.");
		}
	}

}
