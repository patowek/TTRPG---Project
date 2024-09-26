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
		Combat fight = null;
		
		for (Enemies enemy: enemies) {
			if (enemy.getName() == target)
				targetEnemy = enemy;
		}
		
		if (targetEnemy != null) {
			fight = new Combat(player, targetEnemy);
		} else {
			System.out.println("Invalid target. Try again.");
		}
		
		if (fight.hasWon() == true)
			currentRoom.removeEnemy(targetEnemy);
			System.out.print("You have slain " + targetEnemy.getName());
	}

}