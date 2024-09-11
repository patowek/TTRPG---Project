package Main.Java.Logic;

import Main.Java.Classes.Adventurer;
import Main.Java.Enemies.Enemies;
import Main.Java.Map.Room;

public class AttackCommand extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Enemies enemy = currentRoom.getEnemies().get(0);
		currentRoom.removeEnemy(enemy);
		System.out.print("You have slain " + enemy.getClass().getSimpleName());
	}

}