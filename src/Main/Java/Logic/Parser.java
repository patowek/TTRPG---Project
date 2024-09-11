package Main.Java.Logic;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    private Map<String, Command> commands;

    public Parser() {
        commands = new HashMap<>();
        
        //List of supports Commands
        commands.put("move", new MoveCommand());
        commands.put("take", new TakeCommand());
        commands.put("Examine", new ExamineCommand());
        commands.put("attack", new AttackCommand());
    }

    public Command parseCommand(String input) {
        String[] words = input.split(" ");
        String action = getVerb(words);
        String target = getTarget(words);

        Command command = commands.get(action);
        if (command != null) {
            command.setTarget(target);
            return command;
        } else {
            return new UnknownCommand();
        }
    }

    private String getVerb(String[] words) {
        return words.length > 0 ? words[0].toLowerCase() : "";
    }

    private String getTarget(String[] words) {
        return words.length > 1 ? words[1].toLowerCase() : "";
    }
}
