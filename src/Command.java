import Main.Java.Classes.Adventurer;

public abstract class Command {
    protected String target;
    protected Room currentRoom;

    public void setTarget(String target) {
        this.target = target;
    }
    
    public void setCurrentRoom(Room room) {
    	this.currentRoom = room;
    }

    public abstract void execute(Adventurer player, GameLogic game);
}

public class MoveCommand extends Command {
    @Override
    public void execute(Adventurer player, GameLogic game) {
        Room nextRoom = player.getCurrentRoom().getExit(target);
        if (nextRoom != null) {
            player.move(nextRoom);
            System.out.println("You move " + target + " to " + nextRoom.getDescription());
        } else {
            System.out.println("You can't go that way!");
        }
    }
}

public class TakeCommand extends Command {
    @Override
    public void execute(Adventurer player, GameLogic game) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(target);
        if (item != null) {
            player.addItem(item);
            currentRoom.removeItem(item);
            System.out.println("You take the " + target);
        } else {
            System.out.println("There's no " + target + " here.");
        }
    }
}

public class LookCommmand extends Command {
	
	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room 		
	}
}

public class ExamineCommand extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		
	}
	
}

public class AttackCommand extends Command {

	@Override
	public void execute(Adventurer player, GameLogic game) {
		Room currentRoom = player.getCurrentRoom();
		Enemies enemy = currentRoom.getEnemies();
		
		
	}

}

public class UnknownCommand extends Command {
    @Override
    public void execute(Adventurer player, GameLogic game) {
        System.out.println("I don't understand that command.");
    }
		
	}
}
