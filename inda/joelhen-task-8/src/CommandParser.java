/**
 * The CommandParser class attempts to parse ("understand") a command from the user.
 * A command is defined to be of the form [command word] [modifier], where the modifier
 * is optional for certain commands.
 * As an example, the command "go north" will be parsed with the command word "go" and the
 * modifier "north". 
 * @author Gabriel Skoglund
 * @author Joel Henriksson
 */
public class CommandParser {

    /**
     * Attempt to parse a command string from the player. If the command is valid,
     * it will be executed. For instance, if the command is "go north", and the
     * current room has an exit to the north, the effect will be to move the player
     * to the room to the north.
     *
     * @param command the string entered by the player
     * @param state   the current state that the game is in.
     * @param monsterMovement an object representing the movement of the game's monster.
     */
    public static void parse(String command, GameState state, MonsterMovement monsterMovement) {
        // Perform some initial handling of the command, removing any whitespace before
        // and after, turning it to lower case and splitting the command
        // on one or more whitespace characters
        String[] splitCommand = command.trim().toLowerCase().split("\\s+");

        // Check so that the player has entered something
        if (splitCommand.length < 1) {
            printInvalidCommandMessage();
            return;
        }

        // Attempt to match the player input to a command and execute it
        switch (splitCommand[0]) {
            case "go" -> executeGoCommand(splitCommand, state, monsterMovement);
            case "look" -> executeLookCommand(state, monsterMovement);
            case "help" -> printHelpMessage();
            default -> printInvalidCommandMessage();
        }
    }
    
    /**
 * Executes the "go" command to move the player in the specified direction.
 * If the command is missing a direction, it prints a missing modifier message.
 * Otherwise, it attempts to leave the current room in the given direction,
 * updates the game state and monster movement accordingly, and displays information about the new room.
 *
 * @param splitCommand An array containing the components of the "go" command, where index 1 is the direction.
 * @param state The game state object representing the current state of the game.
 * @param monsterMovement An object representing the movement of the game's monster.
 */
    private static void executeGoCommand(String[] splitCommand, GameState state, MonsterMovement monsterMovement) {
        // Check so that we have a direction word
        if (splitCommand.length < 2) {
            printMissingModifierMessage("go");
        } else {
            // Attempt to leave the current room in the given direction
            Room currentRoom = state.getCurrentRoom();
            Room newRoom = currentRoom.go(splitCommand[1]);

            monsterMovement.setPreviousPlayerRoom(currentRoom);
            
            if (newRoom != null) {
                state.setCurrentRoom(newRoom);
                System.out.println("You are in the " + newRoom.getRoomName());
                monsterMovement.monsterAi(currentRoom);
                newRoom.lookAround(state, monsterMovement);
            }
        }
    }

    /**
 * Executes the "look" command to provide information about the current room.
 * Calls the lookAround method of the current room in the game state which
 * updates the player with details about the room and potential interactions with the monster.
 *
 * @param state The game state object representing the current state of the game.
 * @param monsterMovement An object representing the movement of the game's monster.
 */
    private static void executeLookCommand(GameState state, MonsterMovement monsterMovement) {
        state.getCurrentRoom().lookAround(state, monsterMovement);
    }

    /**
 * Prints an error message for when the player has entered an invalid command.
 * Informs the player that the entered command is not recognized,
 */
    private static void printInvalidCommandMessage() {
        System.out.println("I'm sorry, that's not a valid command. " +
                           "Type \"help\" for information about commands.");
    }

    /**
 * Prints an error message for commands missing a required modifier.
 *
 * @param command The command for which a modifier is missing.
 */
    private static void printMissingModifierMessage(String command) {
        System.out.println("I'm sorry, the \"" + command + "\" command requires one more command word. " +
                           "Type \"help\" for information about commands.");
    }

    /**
     * Print out the commands available to the player.
     */
    public static void printHelpMessage() {
        System.out.println("Your available commands are:");
        System.out.println("    \"go <direction>\" - Attempt to leave the current room in the given direction.");
        System.out.println("    \"look\" - Look around the current room");
        System.out.println("    \"help\" - Print this useful help message.");
    }
}