/**
 * Test for the FixedPivotInsertion implementation of Quicksort. Runs the IntSorterTest tests.
 */
public class QuicksortFixedPivotInsertionTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }
}
