import java.util.ArrayList;

public class SetTheory {
    
    /**
     * Generates a set of integers in the range [min, max).
     *
     * @param min The minimum value (inclusive) of the set.
     * @param max The maximum value (exclusive) of the set. Limited to 100 if greater.
     * @return An ArrayList representing the generated set.
     */
    public static ArrayList<Integer> generateSet(int min, int max) {
        ArrayList<Integer> integerList = new ArrayList<>();
        if (max > 100) {
            max = 100;
        }
        if (min < 0) {
            min = 0;
        }

        for(int i = min; i < max; i++) {
            integerList.add(i);
        }

        return integerList;
    }

    /**
     * Computes the union of two sets represented as ArrayLists.
     * 
     * Creates a copy of ArrayList a, loops through the elements of ArrayList b
     * and only adds them to the new ArrayList if they aren't already part of it.
     * The result is then passed to the removeDuplicates method, which removes duplicates
     * and makes sure that the elements are within the correct 0-99 range.
     *
     * @param a The first set as an ArrayList.
     * @param b The second set as an ArrayList.
     * @return An ArrayList representing the union of sets 'a' and 'b' with duplicates removed.
     */
    public static ArrayList<Integer> union(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> unionList = new ArrayList<>(a);
        for (Integer element : b) {
            if (!unionList.contains(element)) {
                unionList.add(element);
            }
        }  
        
        return removeDuplicates(unionList);
    }

    /**
     * Computes the intersection of two sets represented as ArrayLists.
     * 
     * Creates a new ArrayList and adds all the elements of Arraylist b
     * only if ArrayList A also contains them.
     * The result is then passed to the removeDuplicates method, which removes duplicates
     * and makes sure that the elements are within the correct 0-99 range.
     *
     * @param a The first set as an ArrayList.
     * @param b The second set as an ArrayList.
     * @return An ArrayList representing the intersection of sets 'a' and 'b' with duplicates removed.
     */
    public static ArrayList<Integer> intersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> intersectionList = new ArrayList<>();
        for (Integer element : b) {
            if (a.contains(element)) {
                intersectionList.add(element);
            }
        }  
        
        return removeDuplicates(intersectionList);
    }

    /**
     * Computes the complement of a set represented as an ArrayList.
     * 
     * Creates a new ArrayList and adds every Integer between 0-99
     * only if ArrayList a doesn't contain them.
     * The result is then passed to the removeDuplicates method, which removes duplicates
     * and makes sure that the elements are within the correct 0-99 range
     *
     * @param a The set as an ArrayList.
     * @return An ArrayList representing the complement of set 'a' with values from 0 to 99.
     */
    public static ArrayList<Integer> compliment(ArrayList<Integer> a) {
        ArrayList<Integer> ComplimentList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (!a.contains(i)) {
                ComplimentList.add(i);
            }
        }  
        
        return ComplimentList;
    }

    /**
     * Computes the cardinality (number of unique elements) of a set represented as an ArrayList.
     * 
     * ArrayList a is passed to the removeDuplicates method, which removes duplicates
     * and makes sure that the elements are within the correct 0-99 range.
     * The .size() method is then used to return the amount of elements within the ArrayList.
     *
     * @param a The set as an ArrayList.
     * @return The cardinality of the set.
     */
    public static int cardinality(ArrayList<Integer> a) {
        int cardinality  = removeDuplicates(a).size();
        return cardinality;
    }

    
    /**
     * Computes the cardinality (number of unique elements) of the union of two sets represented as ArrayLists.
     * 
     * Creates a copy of ArrayList a, loops through the elements of ArrayList b
     * and only adds them to the new ArrayList if they aren't already part of it.
     * The result is then passed to the removeDuplicates method, which removes duplicates
     * and makes sure that the elements are within the correct 0-99 range.
     * The .size() method is then used to return the amount of elements within the ArrayList.
     *
     * @param a The first set as an ArrayList.
     * @param b The second set as an ArrayList.
     * @return The cardinality of the union of sets 'a' and 'b'.
     */
    public static int cardinalityOfUnion(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> unionList = new ArrayList<>(a);
        for (Integer element : b) {
            if (!unionList.contains(element)) {
                unionList.add(element);
            }
        }  
        
        return removeDuplicates(unionList).size();
    }

    
    /**
     * Removes duplicate elements from an ArrayList and limits values to the range [0, 99].
     * 
     * Creates a new ArrayList, loops through all the elements in ArrayList a
     * and only adds them to the new ArrayList if they aren't already in it
     * or if they are outside of the 0-99 range.
     *
     * @param a The input ArrayList.
     * @return An ArrayList with duplicates removed and values limited to the range [0, 99].
     */
    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> a) {
        ArrayList<Integer> removedDuplicatesList = new ArrayList<>();
        for (Integer element : a) {
            if (!removedDuplicatesList.contains(element) && element >= 0 && element < 100) {
                removedDuplicatesList.add(element);
            }
        }

        return removedDuplicatesList;
    }

    //Main method and tests
    public static void main(String[] args) {
        ArrayList<Integer> setTestList = new ArrayList<>();
        setTestList.add(-1);
        setTestList.add(1);
        setTestList.add(5);
        setTestList.add(10);
        ArrayList<Integer> exampleSet = generateSet(10, 15);
        ArrayList<Integer> exampleSet2 = intersection(generateSet(10, 15), generateSet(14, 18));
        ArrayList<Integer> exampleSet3 = compliment(generateSet(10, 15));
        System.out.println(setTestList);
        System.out.println(exampleSet);
        System.out.println(exampleSet2);
        System.out.println(exampleSet3);
        System.out.println(compliment(setTestList));
        System.out.println(cardinality(setTestList));
        System.out.println(cardinalityOfUnion(setTestList, generateSet(10, 15)));
    }
}
