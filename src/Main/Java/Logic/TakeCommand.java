package Main.Java.Logic;

import Main.Java.Classes.Adventurer;
import Main.Java.Items.Item;
import Main.Java.Map.Room;

public class TakeCommand extends Command {
    @Override
    public void execute(Adventurer player, GameLogic game) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItems().get(0);
        if (item != null) {
            player.setItems(target, target);
            currentRoom.removeItem(item);
            System.out.println("You take the " + target);
        } else {
            System.out.println("There's no " + target + " here.");
        }
    }
}
