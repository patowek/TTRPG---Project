package Main.Java.Logic;

import Main.Java.Map.*;
import Main.Java.Classes.*;

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
