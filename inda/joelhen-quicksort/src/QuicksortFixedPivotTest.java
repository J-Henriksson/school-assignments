/**
 * Test for the FixedPivot implementation of Quicksort. Runs the IntSorterTest tests.
 */
public class QuicksortFixedPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }
}