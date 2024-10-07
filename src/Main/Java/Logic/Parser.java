package Logic;

import java.util.HashMap;
import java.util.Map;

public class Parser {
	private Map<String, Command> commands;

	public Parser() {
		commands = new HashMap<>();

		// List of supports Commands
		commands.put("move", new CommandMove());//
		commands.put("take", new CommandTake());//
		commands.put("examine", new CommandExamine());//
		commands.put("attack", new CommandAttack());//
		commands.put("help", new CommandHelp());
		commands.put("use", new CommandUseItem());//
		commands.put("exit", new CommandExit());//
		commands.put("drop", new CommandDrop());//
		commands.put("equip", new CommandEquip());//
		commands.put("unequip", new CommandUnequip());//
		commands.put("flee", new CommandFlee());
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
			return new CommandUnknown();
		}
	}

	private String getVerb(String[] words) {
		return words.length > 0 ? words[0].toLowerCase() : "";
	}

	private String getTarget(String[] words) {
		return words.length > 1 ? words[1].toLowerCase() : "";
	}
}
