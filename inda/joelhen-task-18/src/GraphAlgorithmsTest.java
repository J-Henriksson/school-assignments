import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for GraphAlgorithms.
 *
 * @author [Name]
 * @version [Date]
 */

public class GraphAlgorithmsTest {
    @Before
    public void setUp() {}

    @Test
    public void hasCycleTrueMultipleComponents() {
        // Arrange
        // Three components:
        // 0 - 1 - 5
        // 2 - 3
        //  \ /
        //   9
        // 4 - 6 - 7 - 8
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(1, 5, 0);
        g.add(9, 2, 0);
        g.add(2, 3, 0);
        g.add(3, 9, 0);
        g.add(4, 6, 0);
        g.add(6, 7, 0);
        g.add(7, 8, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertTrue(hasCycle);
    }

    @Test
    public void hasPathTrueTreeGraph() {
        // Arrange
        //            0
        //           / \
        //          1   2
        //         / \   \
        //        3   4   5
        //       / \   \
        //      6   7   8
        //               \
        //                9
        Graph g = new Graph(10);
        g.add(0, 1, 0);
        g.add(0, 2, 0);
        g.add(1, 3, 0);
        g.add(1, 4, 0);
        g.add(2, 5, 0);
        g.add(3, 6, 0);
        g.add(3, 7, 0);
        g.add(4, 8, 0);
        g.add(8, 9, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 9);

        // Assert
        assertTrue(hasPath);
    }

    @Test
    public void hasCycleFalseSingleComponent() {
        // Arrange
        Graph g = new Graph(4);
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(2, 3, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertFalse(hasCycle);
    }

  @Test
  public void hasCycleTrueSingleComponent() {
        // Arrange
        Graph g = new Graph(4);
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(2, 3, 0);
        g.add(3, 0, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertTrue(hasCycle);
  }

  @Test
  public void hasCycleFalseMultipleComponents() {
        // Arrange
        Graph g = new Graph(6);
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(3, 4, 0);
        g.add(4, 5, 0);

        // Act
        boolean hasCycle = GraphAlgorithms.hasCycle(g);

        // Assert
        assertFalse(hasCycle);
  }

    @Test
    public void graphWithCycleHasPathToSelf() {
        // Arrange
        Graph g = new Graph(4);
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(2, 3, 0);
        g.add(3, 0, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 0);

        // Assert
        assertTrue(hasPath);
    }

    @Test
        public void verteciesOnDifferentComponentsHasPathIsFalse() {
        // Arrange
        Graph g = new Graph(6);
        g.add(0, 1, 0);
        g.add(1, 2, 0);
        g.add(3, 4, 0);
        g.add(4, 5, 0);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 3);

        // Assert
        assertFalse(hasPath);
    }

    @Test
    public void graphWithVerteciesWithoutEdgesHasPathIsFalse() {
        // Arrange
        Graph g = new Graph(3);

        // Act
        boolean hasPath = GraphAlgorithms.hasPath(g, 0, 2);

        // Assert
        assertFalse(hasPath);
    }
}
