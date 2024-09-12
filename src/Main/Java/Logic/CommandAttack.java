package Logic;

import Classes.Adventurer;
import Enemies.Enemies;
import Map.Room;

public class CommandAttack extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Enemies enemy = currentRoom.getEnemies().get(0);
		currentRoom.removeEnemy(enemy);
		System.out.print("You have slain " + enemy.getClass().getSimpleName());
	}

}