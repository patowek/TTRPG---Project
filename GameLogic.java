import java.util.Map;
import java.util.Scanner;

public class GameLogic {
    private Adventurer player;
    private Map<String, Room> rooms;
    private boolean isRunning;
    private Parser parser;

    public GameLogic() {
        this.isRunning = true;
        this.parser = new Parser();
    }

    public void startGame() {
        // Initialize player, rooms, items, etc.
        setupWorld();
        while (isRunning) {
            System.out.println("What would you like to do?");
            String input = getUserInput();
            processInput(input);
            update();
        }
        endGame();
    }

    private void processInput(String input) {
        Command command = parser.parseCommand(input);
        command.execute(player, this);
    }

    private void update() {
        // Handle game updates like checking win/lose conditions
        if (player.hasWon() || player.isDead()) {
            isRunning = false;
        }
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void endGame() {
        System.out.println("Thanks for playing!");
    }

    private void setupWorld() {
        // Initialize rooms, place items, etc.
    }
}
