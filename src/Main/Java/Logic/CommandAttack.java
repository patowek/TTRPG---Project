package Logic;

import java.util.List;

import Classes.Adventurer;
import Enemies.Enemies;
import Map.Room;

public class CommandAttack extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		List<Enemies> enemies = currentRoom.getEnemies();
		Enemies targetEnemy = null;
		Combat fight = game.getActiveCombat();
		
		for (Enemies enemy: enemies) {
			if (enemy.getName().equalsIgnoreCase(target))
				targetEnemy = enemy;
				break;
		}
		
		if (targetEnemy != null) {
			// Initiate combat if needed
			if (fight == null) {
				fight = new Combat(game, targetEnemy);
				game.setActiveCombat(fight);
				
			}
			
			fight.atkAction();
		} else {
			System.out.println("Invalid target. Try again.");
		}
	}

}