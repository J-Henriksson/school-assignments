/**
 * Test for the RandomPivot implementation of Quicksort. Runs the IntSorterTest tests.
 */
public class QuicksortRandomPivotTest extends IntSorterTest {
    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivot();
    }
}
