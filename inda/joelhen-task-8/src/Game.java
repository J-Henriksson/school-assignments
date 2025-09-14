import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Random;

/**
 * The Game class is the main class for the game
 *
 * @author Gabriel Skoglund
 * @author Joel Henriksson
 */
public class Game {
    private static Game game = new Game();
    private static GameState state;
    private static MonsterMovement monsterMovement = new MonsterMovement();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * A simple arrow indicating that the program is waiting for player input.
     * Why not try replacing this symbol with something else that you prefer?
     */
    private static final String PROMPT = "> ";

    public static void main(String[] args) {
        game.generateRoomsFromFile("src/rooms.txt");
        printWelcomeMessage(state);

        // Main game loop, keep reading player input and update game state based on this.
        // This loop should be changed to end once the player has won.
        while (state.checkGameEnd(monsterMovement)) {
            String command = getCommand();
            CommandParser.parse(command, state, monsterMovement);
        }
    }

    private static String getCommand() {
        System.out.print(PROMPT);
        // Read a line of user input from the terminal
        String command = scanner.nextLine();
        // Remove the prompt from the start of the line
        command = command.replaceFirst(PROMPT, "");
        return command;
    }

    /**
 * Prints the welcome, look around and help messages.
 *
 * @param state The game state object representing the current state of the game.
 */
    private static void printWelcomeMessage(GameState state) {
        System.out.println(" \n" + "The world outside lies in ruin, the result of a catastrophic nuclear war. \n" + 
        "As the lone survivor, you find refuge in the depths of an underground bunker. \n" + 
        "As you enter the dimly lit bunker entrance the door shuts close behind you. \n" + 
        "You quickly realize that you are not alone. Inside the bunker roams a deadly radioactive mutant. \n" + 
        "Your only shot at survival is to explore the bunker and find a way to escape, all while avoiding crossing paths with the mutant. \n" + 
        "Good luck. \n" + 
        "");
        state.getCurrentRoom().lookAround(state, monsterMovement);
        CommandParser.printHelpMessage();
    }

    /**
 * Generates rooms from a file to create the game world.
 * 
 * Extracts room and exit infromation from a file and 
 * establishes connections between rooms.
 * Also randomly selects a room to place the mutant and initializes the game state.
 *
 * @param filename The name of the file containing the room and exit information.
 * @throws IOException If an I/O error occurs while reading the file.
 */
    private void generateRoomsFromFile(String filename) {
        HashMap<String, Room> worldModel = new HashMap<>();

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));
            
            String line = file.readLine();

            Random random = new Random();
            String monsterRoom = "";
            int monsterRoomNumber = random.nextInt(7) + 2;
            int roomCount = 0;

            // Reads the file line by line and splits each line into words
            while (line != null) {
                String[] dataArray = line.split(";");

                if (dataArray[0].equals("Room")) {
                    roomCount++;
                    if (roomCount == monsterRoomNumber) {
                        monsterRoom = dataArray[1];
                    }

                    String roomName = dataArray[1];
                    int xCoordinate = Integer.parseInt(dataArray[2]);
                    int yCoordinate = Integer.parseInt(dataArray[3]);
                    String roomDescription = dataArray[4];

                    Room room= new Room(roomDescription, xCoordinate, yCoordinate, roomName);
                    worldModel.put(roomName, room);
                }
                else if (dataArray[0].equals("Exit")) {
                    String room = dataArray[1];
                    String exitDirection = dataArray[2];
                    String destinationRoom = dataArray[3];

                    worldModel.get(room).addExit(exitDirection,  worldModel.get(destinationRoom));
                }

                line = file.readLine();
            }

            file.close();

            state = new GameState(worldModel.get("Bunker Entrance"), worldModel.get("Escape Hatch"), worldModel.get(monsterRoom), monsterMovement);
            
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());  

            System.exit(1);  
        }   
    }
}