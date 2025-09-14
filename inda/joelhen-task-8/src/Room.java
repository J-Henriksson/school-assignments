import java.util.HashMap;
import java.util.Map;

/**
 * The Room class contains information about the room that the player is currently in.
 * @author Gabriel Skoglund
 * @author Joel Henriksson
 */
public class Room {

    /**
     * The exits map contains keys which are directions and values which are the rooms that
     * the exit leads to.
     */
    private Map<String, Room> exits = new HashMap<>();

    private String description;
    private int xCoordinate;
    private int yCoordinate;
    private String name;

    /**
 * Constructor for creating a Room object.
 * Initializes a room with the provided description, coordinates, and name.
 *
 * @param description The description of the room.
 * @param xCoordinate The x-coordinate of the room's location.
 * @param yCoordinate The y-coordinate of the room's location.
 * @param roomName The name of the room.
 */
    public Room(String description, int xCoordinate, int yCoordinate, String roomName) {
        this.description = description;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        name = roomName;
    }

    /**
     * @return The X-coordinate of the room the player is currently in.
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * @return The Y-coordinate of the room the player is currently in.
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * @return The name of the room the player is currently in.
     */
    public String getRoomName() {
        return name;
    }

    /**
     * Add an exit from this room.
     * @param direction the direction in which the exit is.
     * @param toRoom the room that this exit leads to.
     */
    public void addExit(String direction, Room toRoom) {
        exits.put(direction, toRoom);
    }

    /**
     * Attempt to leave this room in the given direction.
     * @param direction the direction in which to move the player.
     * @return the room that the player ends up in. May be null if
     *         there is no exit from this room in that direction.
     */
    public Room go(String direction) {
        Room newRoom = exits.get(direction);
        if (newRoom == null){
            System.out.println("You can't go that way!");
            printExits();
        }
        return newRoom;
    }

    /**
     * Print the exits that are available from this room.
     */
    public void printExits() {
        System.out.print("There are exits in the directions: ");
        for (String direction : exits.keySet())
            System.out.print(direction + " ");
        System.out.println();
    }

    /**
     * Look around the current room, printing the room descriptions and the
     * available exits. Also calls the method for calculating whether the player hears the noises
     * of the monster or not.
     * 
     * @param state   the current state that the game is in.
     * @param monsterMovement an object representing the movement of the game's monster.
     */
    public void lookAround(GameState state, MonsterMovement monsterMovement) {
        System.out.println(description);
        monsterMovement.monsterLocation(state);
        printExits();
    }
}