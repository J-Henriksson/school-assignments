/**
 * Test for the RandomPivotInsertion implementation of Quicksort. Runs the IntSorterTest tests.
 */
public class QuicksortRandomPivotInsertionTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivotInsertion();
    }
}
