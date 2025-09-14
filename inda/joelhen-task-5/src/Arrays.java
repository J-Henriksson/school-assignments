public class Arrays {


    /**
     * Calculates the average of an array of integers.
     *
     * @param array An array of integers.
     * @return The average of the elements in the array.
     */
    public static int average(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        sum /= array.length;

        return sum;
    }

    /**
     * Calculates the average of an array of doubles.
     *
     * @param array An array of doubles.
     * @return The average of the elements in the array.
     */
    public static double average(double[] array) {
        double sum = 0;
        for (double element : array) {
            sum += element / array.length;
        }

        return sum;
    }

    /**
     * Finds and returns the smallest element in an array of integers.
     *
     * @param array An array of integers.
     * @return The smallest element in the array.
     */
    public static int smallestElement(int[] array) {
        int smallestInt = Integer.MAX_VALUE;
            for (int element : array) {
            if (smallestInt > element) {
                smallestInt = element;
            }
        }
        return smallestInt;
    }

    /**
     * Reverses the order of elements in an array of integers.
     *
     * @param array An array of integers.
     * @return A new array with elements in reverse order.
     */
    public static int[] reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }

        return reversedArray;
    }

    /**
     * Extracts even numbers from an array of integers and returns them in a new array.
     *
     * @param array An array of integers.
     * @return A new array containing even numbers from the input array.
     */
    public static int[] evenNumbers(int[] array) {
        int amountOfEvenNumbers = 0;
        int arrayIndex = 0;

        for (int element : array) {
            if (element % 2 == 0) {
                amountOfEvenNumbers++;
            }
        }

        int[] evenNumbers = new int[amountOfEvenNumbers];

        for (int element : array) {
            if (element % 2 == 0) {
                evenNumbers[arrayIndex] = element;
                arrayIndex++;
            }
        }

        return evenNumbers;
    }

    //Main method and tests
    public static void main(String[] args) {
        int[] testArray = {17, -90, 5, 4, 8, 16, 11, 9};
        double[] testArrayDoubles = {5, 8, 11};
        System.out.println(Arrays.average(testArray));
        System.out.println(Arrays.average(testArrayDoubles));
        System.out.println(Arrays.smallestElement(testArray));
        System.out.println(Arrays.reverse(testArray)[0]);
        System.out.println(Arrays.evenNumbers(testArray)[0]);

    }
}