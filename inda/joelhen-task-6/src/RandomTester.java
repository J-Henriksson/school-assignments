import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

public class RandomTester {

    static Random rand = new Random();

    /**
     * Generates a list of random integers within a specified range.
     *
     * @param n The number of random integers to generate.
     * @return An ArrayList of randomly generated integers.
     */
    public static ArrayList<Integer> generateNumbers(int n) {
        ArrayList<Integer> generatedNumbersList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            generatedNumbersList.add(rand.nextInt(100) + 1);
        }

        return generatedNumbersList;
    }

    /**
     * Shuffles the elements of an ArrayList.
     *
     * @param list The ArrayList to be shuffled.
     * @return A shuffled ArrayList.
     */
    public static ArrayList<Integer> shuffle(ArrayList<Integer> list) {
        ArrayList<Integer> List = new ArrayList<>(list);
        ArrayList<Integer> shuffledList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            int randomInt = rand.nextInt(i + 1);
            shuffledList.add(List.get(randomInt));
            List.remove(randomInt);
        }

        return shuffledList;
    }
    
    /**
     * Generates a sequence of dice.
     *
     * @param n The number of dice to create.
     * @return An ArrayList of Dice objects.
     */
    public static ArrayList<Dice>sequenceOfDice(int n) {
        ArrayList<Dice> diceList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            diceList.add(new Dice());
        }
        return diceList;
    }

    /**
     * Generates a sequence of biased dice.
     *
     * @param n The number of biased dice to create.
     * @return An ArrayList of BiasedDice objects.
     */
    public static ArrayList<BiasedDice>sequenceOfBiasedDice(int n) {
        ArrayList<BiasedDice> biasedDiceList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            biasedDiceList.add(new BiasedDice());
        }
        return biasedDiceList;
    }

    /**
     * Finds the sum of each pair of adjacent dice in a sequence of dice and returns the largest sum.
     *
     * @param sequence The ArrayList of Dice objects.
     * @return The largest sum of adjacent dice rolls.
     * @throws IllegalArgumentException if the ArrayList contains fewer than 2 elements.
     */
    public static int highestAdjacentRolls(ArrayList<Dice> sequence) {
        if (sequence.size() < 2) {
            throw new IllegalArgumentException("ArrayList must contain at least 2 elements.");
        }
        int largestSumOfAdjacent = sequence.get(0).getValue() + sequence.get(1).getValue();
        for (int i = 1; i < sequence.size() - 1; i++) {
            int sumOfAdjacent = sequence.get(i).getValue() + sequence.get(i + 1).getValue();
            if (sumOfAdjacent > largestSumOfAdjacent) {
                largestSumOfAdjacent = sumOfAdjacent;
            }
        }

        return largestSumOfAdjacent;
    }
    
    /**
     * Finds the sum of each pair of adjacent dice in a sequence of dice and returns the smallest sum.
     *
     * @param sequence The ArrayList of Dice objects.
     * @return The smallest sum of adjacent dice rolls.
     * @throws IllegalArgumentException if the ArrayList contains fewer than 2 elements.
     */
    public static int smallestAdjacentRolls(ArrayList<Dice> sequence) {
        if (sequence.size() < 2) {
            throw new IllegalArgumentException("ArrayList must contain at least 2 elements.");
        }
        int smallestSumOfAdjacent = sequence.get(0).getValue() + sequence.get(1).getValue();
        for (int i = 1; i < sequence.size() - 1; i++) {
            int sumOfAdjacent = sequence.get(i).getValue() + sequence.get(i + 1).getValue();
            if (sumOfAdjacent < smallestSumOfAdjacent) {
                smallestSumOfAdjacent = sumOfAdjacent;
            }
        }

        return smallestSumOfAdjacent;
    }

    /**
     * Removes all occurrences of a specific value from an ArrayList of Dice objects.
     *
     * @param sequence The ArrayList of Dice objects.
     * @param n The value to be removed.
     * @return An ArrayList with all occurrences of 'n' removed.
     */
    public static ArrayList<Dice> remove(ArrayList<Dice> sequence, int n) {
        ArrayList<Dice> removedList = new ArrayList<>(sequence);

        Iterator<Dice> iterator = removedList.iterator();
        while (iterator.hasNext()) {
            Dice dice = iterator.next();
            if (dice.getValue() == n) {
                iterator.remove();
            }
        }

        return removedList;
    }

    // Tests
    public static void main(String[] args) {
        final int AMOUNT_OF_NUMBERS = 5;
        ArrayList<Integer> randomNumbers = generateNumbers(AMOUNT_OF_NUMBERS); 
         ArrayList<Dice> diceTest = new ArrayList<>(sequenceOfDice(4));
         ArrayList<Dice> biasedDiceTest = new ArrayList<>(sequenceOfBiasedDice(4));
         System.out.println(randomNumbers);
         System.out.println(shuffle(randomNumbers));

         for(int i = 0; i < diceTest.size(); i++) {
            System.out.println("Dice " + (i + 1) + ": " + diceTest.get(i).toString());
        }
        for(int i = 0; i < biasedDiceTest.size(); i++) {
            System.out.println("BaisedDice " + (i + 1) + ": " + biasedDiceTest.get(i).toString());
        }

         System.out.println(highestAdjacentRolls(diceTest));
         System.out.println(highestAdjacentRolls(biasedDiceTest));
         System.out.println(remove(diceTest, 1));
    }
}   