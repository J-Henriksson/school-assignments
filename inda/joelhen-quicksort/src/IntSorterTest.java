 import org.junit.Test;
 import org.junit.Before;
 import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;

import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

 /**
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @author Joel Henriksson
  * @version 2024-03-01
  */
 public abstract class IntSorterTest {

    private int[] unsortedEvenArray;

    private int[] unsortedOddArray;

    private int[] unsortedAscendingArray;

    private int[] unsortedDescendingArray;

    private int[] unsortedRandomArray;

    private int[] unsortedSuperBigArray;

     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
        unsortedEvenArray = new Data(100, 200, Data.Order.RANDOM).get();
        unsortedOddArray = new Data(99, 200, Data.Order.RANDOM).get();
        unsortedAscendingArray = new Data(100, 200, Data.Order.ASCENDING).get();
        unsortedDescendingArray = new Data(100, 200, Data.Order.DESCENDING).get();
        unsortedRandomArray = new Data(99, 200, Data.Order.RANDOM).get();
        unsortedSuperBigArray = new Data(100000, 100000, Data.Order.RANDOM).get();
        
     }
    
     /**
     * Asserts that sorting an empty array has no effects.
     */
    @Test
    public void quicksortHasNoEffectWhenArrayIsEmpty() {
        // Arrange
        int[] emptyArray = new int[]{};
        // Act
        getIntSorter().sort(emptyArray);
        // Assert
        assertThat(emptyArray.length, equalTo(0));
    }

    /**
     * Asserts that sorting an array with a single element has no effects.
     */
    @Test
    public void quicksortHasNoEffectWhenListHasSingleElement() {
        //Act
        int[] singleElementArray = new int[]{1};
        int[] actual = singleElementArray.clone();

        //Arrange
        getIntSorter().sort(actual);

        //Assert
        assertThat(actual, equalTo(singleElementArray));
    }

    /**
     * Asserts that quicksort on an even array produces the correct result.
     */
    @Test
    public void quicksortOnEvenArrayIsCorrect() {
        //Act
        int[] actual = unsortedEvenArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }

    /**
     * Asserts that quicksort on an odd array produces the correct result.
     */
    @Test
    public void quicksortOnOddArrayIsCorrect() {
        //Act
        int[] actual = unsortedOddArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }

    /**
     * Asserts that quicksort on an ascending array produces the correct result.
     */
    @Test
    public void quicksortOnAscendingArrayIsCorrect() {
        //Act
        int[] actual = unsortedAscendingArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }

    /**
     * Asserts that quicksort on an descending array produces the correct result.
     */
    @Test
    public void quicksortOnDescendingArrayIsCorrect() {
        //Act
        int[] actual = unsortedDescendingArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }

    /**
     * Asserts that quicksort on a random array produces the correct result.
     */
    @Test
    public void quicksortOnRandomArrayIsCorrect() {
        //Act
        int[] actual = unsortedRandomArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }

    /**
     * Asserts that quicksort on a really big array produces the correct result.
     */
    @Test
    public void quicksortOnSuperBigArrayIsCorrect() {
        //Act
        int[] actual = unsortedSuperBigArray;
        int[] Expected = actual.clone();

        //Arrange
        getIntSorter().sort(actual);
        Arrays.sort(Expected);
        
        //Assert
        assertArrayEquals(Expected, actual);
    }
 }
