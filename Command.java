public abstract class Command {
    protected String target;

    public void setTarget(String target) {
        this.target = target;
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
    public void execute(Player player, Game game) {
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

public class UnknownCommand extends Command {
    @Override
    public void execute(Player player, Game game) {
        System.out.println("I don't understand that command.");
    }
}
