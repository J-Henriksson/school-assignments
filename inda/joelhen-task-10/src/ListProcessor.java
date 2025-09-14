import java.util.List;
import java.util.ArrayList;
import java.util.Random;
public class ListProcessor {

    /**
     * Generates an array with an integer sequence based on the two parameters.
     * 
     * @param from The start value of the sequence (inclusive).
     * @param to The end of the sequence (exclusive).
     * @return An integer array containing the sequence.
     * @throws IllegalArgumentException if from is greater than to.
     */
    public int[] arraySequence(int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("From cannot be greater than to");
        }
        else {
            int[] arraySequence = new int[to - from];
            for (int i = from; i < to; i++) {
                arraySequence[i - from] = i;
            }
            return arraySequence;
        }
    }

    /**
     * Generates a list of integers in a sequence from 'from' (inclusive) to 'to' (exclusive).
     *
     * @param from The start value of the sequence.
     * @param to The end value of the sequence (exclusive).
     * @return A list of integers representing the sequence.
     * @throws IllegalArgumentException If from is greater than to.
     */
    public List<Integer> listSequence(int from, int to) {
        if ( from > to) {
            throw new IllegalArgumentException("From cannot be greater than to");
        }
        else {
            ArrayList<Integer> listSequence = new ArrayList<>();
            for (int i = from; i < to; i++) {
                listSequence.add(i);
            }

            return listSequence;
            }
    }

    /**
     * Shuffles an array of integers using the Fisher-Yates algorithm.
     *
     * @param numbers The array of integers to be shuffled.
     * @return A shuffled array of integers.
     */
    public int[] shuffled (int[] numbers) {
        // Implementing Fisher-Yates algorithm
        Random random = new Random();
        int[] shuffled = numbers.clone();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int temp = shuffled[i];
            int randomElement = random.nextInt(numbers.length);
            shuffled[i] = shuffled[randomElement];
            shuffled[randomElement] = temp;
        }

        return shuffled;
    }

    /**
     * Shuffles a list of integers.
     *
     * @param numbers The list of integers to be shuffled.
     * @return A shuffled list of integers.
     */
    public static List<Integer> shuffled(List<Integer> numbers) {
        Random random = new Random();
        ArrayList<Integer> List = new ArrayList<>(numbers);
        ArrayList<Integer> shuffledList = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            int randomInt = random.nextInt(i + 1);
            shuffledList.add(List.get(randomInt));
            List.remove(randomInt);
        }

        return shuffledList;
    }

    /**
     * Calculates the sum of integers in an array using an iterative method.
     *
     * @param numbers The array of integers to be summed.
     * @return The sum of the integers in the array.
     */
    public int sumIterative(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum = sum + i;
        }
        return sum; 
    }

    /**
     * Calculates the sum of integers in a list using an iterative method.
     *
     * @param numbers The list of integers to be summed.
     * @return The sum of the integers in the list.
     */
    public int sumIterative(List<Integer> numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * Calculates the sum of integers in an array using a recursive approach.
     *
     * @param numbers The array of integers to be summed.
     * @return The sum of the integers in the array.
     */
    public int sumRecursive(int[] numbers) {
        return sumRecursiveHelper(numbers, 0);
    }

    public int sumRecursiveHelper(int[] numbers, int index) {
        if (index == numbers.length) {
            return 0;
        }
        else {
            return numbers[index] + sumRecursiveHelper(numbers, index + 1);
        }
    }

    /**
     * Calculates the sum of integers in a list using a recursive approach.
     *
     * @param numbers The list of integers to be summed.
     * @return The sum of the integers in the list.
     */
    public int sumRecursive(List<Integer> numbers) {
        return sumRecursiveHelper(numbers, 0);
    }

    public int sumRecursiveHelper(List<Integer> numbers, int index) {
        if (index == numbers.size()) {
            return 0;
        }
        else {
            return numbers.get(index) + sumRecursiveHelper(numbers, index + 1);
        }
    }
}