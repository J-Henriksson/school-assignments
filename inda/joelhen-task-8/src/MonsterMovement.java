import java.util.Random;

/**
 * The Monster movement class is used to calculate att determine the movement of the mutant.
 * It's also used to give the player the general location of the mutant based on whether
 * the mutant makes noise or not. The class also stores different
 * texts that are displayed when the game is won or lost.
 *
 * @author Joel Henriksson
 */
public class MonsterMovement {
    private Room currentMonsterRoom;
    private Random random = new Random();
    private Room previousPlayerRoom;
    private Room previousMonsterRoom;
    private int ambushvalue = 0; 

    /**
     * Retrieves the current room occupied by the monster.
     *
     * @return The current monster room.
     */
    public Room getCurrentMonsterRoom() {
        return currentMonsterRoom;
    }

    /**
     * Retrieves the previous room occupied by the player.
     *
     * @return The previous player room.
     */
    public Room getPreviousPlayerRoom() {
        return previousPlayerRoom;
    }

     /**
     * Retrieves the previous room occupied by the monster.
     *
     * @return The previous monster room.
     */
    public Room getPreviousMonsterRoom() {
        return previousMonsterRoom;
    }

    /**
     * Retrieves the current ambush value.
     * Which determines whether or not the mutant will try and ambush the player.
     *
     * @return The current ambush value.
     */
    public int getAmbushValue() {
        return ambushvalue;
    }

    /**
     * Sets the current room occupied by the monster.
     *
     * @param currentMonsterRoom The new current monster room.
     */
    public void setCurrentMonsterRoom(Room currentMonsterRoom) {
        this.currentMonsterRoom = currentMonsterRoom;
    }

    /**
     * Sets the previous room occupied by the player.
     *
     * @param previousPlayerRoom The new previous player room.
     */
    public void setPreviousPlayerRoom(Room previousPlayerRoom) {
        this.previousPlayerRoom = previousPlayerRoom;
    }

    /**
     * Sets the previous room occupied by the monster.
     *
     * @param previousMonsterRoom The new previous monster room.
     */
    public void setPreviousMonsterRoom(Room previousMonsterRoom) {
        this.previousMonsterRoom = previousMonsterRoom;
    }

    /**
     * Sets the current ambush value.
     *
     * @param ambushvalue The new ambush value.
     */
    public void setAmbushValue(int ambushvalue) {
        this.ambushvalue = ambushvalue;
    }

    /**
     * Implements the monster's ai for movement based on the player's location.
     * Handles random movement and ambush scenarios, updating the monster's position accordingly.
     *
     * @param playerRoom The current room occupied by the player.
     */
    public void monsterAi(Room playerRoom) {
        int randomMovementPath = random.nextInt(2);
        boolean sameYCoordinate = playerRoom.getYCoordinate() == getCurrentMonsterRoom().getYCoordinate();
        boolean sameXCoordinate = playerRoom.getXCoordinate() == getCurrentMonsterRoom().getXCoordinate();
        boolean ambush = getAmbushValue() > 1;

        setPreviousMonsterRoom(getCurrentMonsterRoom());

        //System.out.println(ambush);

        if (!sameYCoordinate && !sameXCoordinate) {
            if (randomMovementPath == 1) {
                 if (playerRoom.getXCoordinate() < getCurrentMonsterRoom().getXCoordinate()) {
                setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
            }
            else {
                setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
            }
            }
            else {
                if (playerRoom.getYCoordinate() < getCurrentMonsterRoom().getYCoordinate()) {
                setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
            }
            else {
                setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
            }   
            }

        }
        else if (!(playerRoom.getYCoordinate() == getCurrentMonsterRoom().getYCoordinate())) {
            if (playerRoom.getYCoordinate() < getCurrentMonsterRoom().getYCoordinate()) {
                if (ambush) {
                    if (playerRoom.getXCoordinate() == 3) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                    }
                    else if (playerRoom.getXCoordinate() == 1) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                    }
                    else {
                        if (randomMovementPath == 0) {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                        }
                        else {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                        }
                    }
                }
                else {
                    setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                }
            }
            else {
                if (ambush) {
                    if (playerRoom.getXCoordinate() == 3) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                    }
                    else if (playerRoom.getXCoordinate() == 1) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                    }
                    else {
                        if (randomMovementPath == 0) {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                        }
                        else {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                        }
                    }
                }
                else {
                    setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                }
            }
        }
        else if (!(playerRoom.getXCoordinate() == getCurrentMonsterRoom().getXCoordinate())) {
            if (playerRoom.getXCoordinate() < getCurrentMonsterRoom().getXCoordinate()) {
                if (ambush) {
                    if (playerRoom.getYCoordinate() == 3) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                    }
                    else if (playerRoom.getYCoordinate() == 1) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                    }
                    else {
                        if (randomMovementPath == 0) {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                        }
                        else {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                        }
                    }
                }
                else {
                    setCurrentMonsterRoom(getCurrentMonsterRoom().go("west"));
                }
            }
            else {
                if (ambush) {
                    if (playerRoom.getYCoordinate() == 3) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                    }
                    else if (playerRoom.getYCoordinate() == 1) {
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("north"));
                        setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                    }
                    else {
                        if (randomMovementPath == 0) {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                        }
                        else {
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("south"));
                            setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                        }
                    }
                }
                else {
                    setCurrentMonsterRoom(getCurrentMonsterRoom().go("east"));
                }
            }
        }
        if (getCurrentMonsterRoom() == getPreviousPlayerRoom()) {
            setAmbushValue(getAmbushValue() + 1);
        }
        else {
            setAmbushValue(0);
        }
    }

    /**
     * Displays information about the relative location of the monster to the player.
     * Provides hints about the monster's presence in adjacent or diagonal rooms,
     * based on a random chance if the monster is "heard" or not.
     *
     * @param gameState The game state object representing the current state of the game.
     */
    public void monsterLocation(GameState gameState) {
        if (!(gameState.getCurrentRoom() == getCurrentMonsterRoom()) || !(getPreviousPlayerRoom() == getCurrentMonsterRoom() && getPreviousMonsterRoom() == gameState.getCurrentRoom())) {
            int randomChance = random.nextInt(3);
            int randomChance2 = random.nextInt(2);
            int playerX = gameState.getCurrentRoom().getXCoordinate();
            int playerY = gameState.getCurrentRoom().getYCoordinate();
            int monsterX = getCurrentMonsterRoom().getXCoordinate();
            int monsterY = getCurrentMonsterRoom().getYCoordinate();

            if (monsterX == playerX + 1 && monsterY == playerY) {
                if (!(randomChance == 1) || getPreviousPlayerRoom() == null) {
                    System.out.println("Directly east, the mutant's haunting presence is unmistakable");
                }
            }
            else if (monsterX == playerX - 1 && monsterY == playerY) {
                if (!(randomChance == 1) || getPreviousPlayerRoom() == null) {
                    System.out.println("Directly west, the eerie sounds of its movements loudly echo through the bunker.");
                }
            }
            else if (monsterX == playerX && monsterY == playerY + 1) {
                if (!(randomChance == 1) || getPreviousPlayerRoom() == null) {
                    System.out.println("The mutant's presence is directly north of you. \n" + 
                "You can hear the unsettling sounds of its movements and growling.");
                }
            }
            else if (monsterX == playerX && monsterY == playerY - 1) {
                if (!(randomChance == 1) || getPreviousPlayerRoom() == null) {
                    System.out.println("The mutant is directly to the south. \n" + 
                 "You sense its chilling presence looming just beyond the nearby wall.");
                }
            }

            else if (randomChance2 == 1 || getPreviousPlayerRoom() == null) {
                if (monsterX > playerX && monsterY > playerY) {
                    System.out.println("To the northeast, a strange clicking noise resonates, \n" + 
                    "hinting at the mutant's peculiar movements.");
                }
                else if (monsterX < playerX && monsterY > playerY) {
                    System.out.println("A faint hiss carries from the northwest");
                }
                else if (monsterX > playerX && monsterY < playerY) {
                    System.out.println("From the southeast, you hear an occasional low growl");
                }
                else if (monsterX < playerX && monsterY < playerY) {
                    System.out.println("From the southwest, a faint dragging noise suggests \n" + 
                    "the mutant is slowly making its way through the bunker.");
                }

                else if (monsterX == playerX && monsterY > playerY) {
                    System.out.println("Distant footsteps echo from the north, a telltale \n" + 
                    "sign of the mutant's calculated advance.");
                }
                else if (monsterX == playerX && monsterY < playerY) {
                    System.out.println("From the south, you hear the faint shuffle of movement");
                }
                else if (monsterX > playerX && monsterY == playerY) {
                    System.out.println("To the east, you catch the faint hum of mutated breathing");
                }
                else if (monsterX < playerX && monsterY == playerY) {
                    System.out.println("From the west, you hear the subtle tapping of claws");
                }
            }
        }
    }

    /**
     * Handles win and lose scenarios based on the current room occupied by the player
     * when the player is caught by the mutant.
     * Prints corresponding messages for different rooms, indicating survival or death.
     *
     * @param roomName The name of the current room occupied by the player.
     */
    public void winLoseScenarios(String roomName) {
        switch (roomName) {
            case "Bunker Entrance": {
                System.out.println("You see the mutant's glowing eyes pierce the darkness. \n" + 
                "an otherworldly howl echoes through the confined space. \n" + 
                "The last thing you see is the mutant lunging toward you before everything goes silent. You die.");
                break;
            }
            case "Living Quarters": {
                System.out.println("You see the mutant in the distance. \n" + 
                "Desperation fills the air as you try to hide among the abandoned bunk beds. \n" + 
                "The mutant's distorted silhouette emerges, casting an eerie glow. \n" + 
                "Its mutated limbs reach out, and as it closes in, the room is consumed by the ghastly glow of radiation. You die.");
                break;
            }
            case "Mess Hall": {
                System.out.println("The mutant's presence disrupts the eerie calm of the mess hall. \n" + 
                "You overturn tables in a futile attempt to create a barricade yourself. \n" + 
                "The mutant effortlessly crashes through, and with a blinding surge of radiation turns the space into a chamber of lethal light. You die.");
                break;
            }
            case "Medical Bay": {
                System.out.println("In the sterile silence of the medical bay, your breath catches as the mutant's distorted figure appears. \n" + 
                "The shattered remnants of medical equipment provide no sanctuary as the mutant's touch sends shockwaves of radiation through your body. You die.");
                break;
            }
            case "Generator Room": {
                System.out.println("Desperation takes hold as the mutant approaches in the malfunctioning generator room. \n" + 
                "In a final act of defiance, you override the controls, triggering a catastrophic overload. \n" + 
                "The room erupts in blinding light as the generator unleashes an uncontrollable surge of energy, engulfing both you and the mutant. You both die.");
                break;
            }
            case "Storage Room": {
                System.out.println("The mutant's arrival in the barren storage room transforms the atmosphere into a chamber of doom. \n" + 
                "Its mutated limbs lash out with a frenzied brutality, tearing through the air. \n" + 
                "The cold metal shelves littered throughout the room bear witness to your gruesome end. You die.");
                break;
            }
            case "Command Bay": {
                System.out.println("The command bay's consoles flicker violently as the mutant breaches the room. \n" + 
                "In a brutal display of power, the mutant's irradiated touch sends shockwaves through your body, contorting it in unnatural ways. \n" + 
                "The last image burned into the console screens is a distorted reflection of your agonizing demise. You die");
                break;
            }
            case "Armory": {
                Random random = new Random();
                int survivalChance = random.nextInt(2);
                if (survivalChance == 0) {
                    System.out.println("The mutant emerges with unnatural speed. \n" + 
                    "Your attempt to arm yourself quickly proves itself as futile as you are overpowered. You die.");
                }
                else {
                    System.out.println("In the dim armory, the mutant emerges. \n" + 
                "Desperately looking around you sieze what seems to be a functional gun. With precise shots, you catch the mutant off guard, driving it back. \n" + 
                "A final, well-aimed bullet incapacitates the creature. The armory, once a scene of doom, now echoes with your unexpected triumph. You survive.");   
                }
                break;
            }
            case "Escape Hatch": {
                Random random = new Random();
                int survivalChance = random.nextInt(2);
                if (survivalChance == 0) {
                    System.out.println("Climbing the rusted ladder, you glimpse the mutant ascending with unearthly speed. \n" + 
                    "Just as you open the hatch the mutant grabs hold of your leg and pulls you down. You die.");
                }
                else {
                    System.out.println("Climbing the rusted ladder, you glimpse the mutant ascending with unearthly speed. \n" + 
                    "Just as you open the hatch the mutant grabs hold of your leg, you gather up all of your force and kick it. \n" + 
                    "In a moment of pure luck this proves successful and the mutant tumbles down, screaming. You survive.");   
                }
                break;
            }
        }
    }

}
