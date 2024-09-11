package Main.Java.Logic;

import Main.Java.Classes.Adventurer;
import Main.Java.Items.Item;
import Main.Java.Map.Room;

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
