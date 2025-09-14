/**
 * The GameState class contains information about the current state of the game like the location
 * of the player. The calss also contains a method which evaluates the game's win and lose conditions.
 * @author Gabriel Skoglund
 * @author Joel Henriksson
 */
public class GameState {
    private Room currentRoom;
    private Room winRoom;

    /**
* Constructor for creating a new GameState.
* Initializes the game state with the specified starting room, win room, and monster room.
* Additionally, sets the initial position of the game's monster using the provided MonsterMovement object.
*
* @param startingRoom The room where the player starts.
* @param winRoom The room associated with a winning the game.
* @param monsterRoom The room where the game's monster is initially placed.
* @param monsterMovement An object representing the movement of the game's monster.
    */
    public GameState(Room startingRoom, Room winRoom, Room monsterRoom, MonsterMovement monsterMovement) {
        currentRoom = startingRoom;
        this.winRoom = winRoom;
        monsterMovement.setCurrentMonsterRoom(monsterRoom);
    }

    /**
     * @return The room the player is currently in.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
    * @return The room associated with a winning condition.
    */
    public Room getWinRoom() {
        return winRoom;
    }


    /**
     * Update the room that the player is in.
     * @param currentRoom the new current room.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
* Checks if the game has ended and handles different win/lose scenarios.
* @param monsterMovement an object representing the movement of the game's monster.
* @return true if the game continues, false if it has ended.
   */
    public  boolean checkGameEnd(MonsterMovement monsterMovement) {
        //System.out.println("Mutant is in " + monsterMovement.getCurrentMonsterRoom().getRoomName());
        if ((getCurrentRoom() == monsterMovement.getCurrentMonsterRoom()) || (monsterMovement.getPreviousPlayerRoom() == monsterMovement.getCurrentMonsterRoom() && monsterMovement.getPreviousMonsterRoom() == getCurrentRoom())) {
            monsterMovement.winLoseScenarios(getCurrentRoom().getRoomName());
            return false;
        }
        else if (getCurrentRoom() == getWinRoom()) {
            System.out.println("You reach the final chamber, where a rusted ladder leads upward. \n" + 
            "The hatch above promises the hope of a renewed world. The distant growls of the pursuing monster drive you to climb faster. You survive.");
            return false;
        }
        else {
            return true;
        }
    }
}