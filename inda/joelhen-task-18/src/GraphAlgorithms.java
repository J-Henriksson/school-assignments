import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for solving graph problems.
 *
 * @author Joel Henriksson
 * @version 2024-02-23
 */

public class GraphAlgorithms {

    /**
    * Determines if a component has a cycle.
    *
    * @param g the graph to search
    * @param v the node to start at
    * @param visited boolean array keeping track of visited nodes
    * @param parent parent node of v
    * @return true if component has cycle, false otherwise
    */
    private static boolean DFS(Graph g, int v, boolean[] visited, int parent) {
        visited[v] = true; // Marks the current vertex as visited.
        
        Iterator<Integer> iterator = g.neighbors(v);
        while (iterator.hasNext()) {
            int neighbor = iterator.next();
            // Visits the neighbor if it hasn't been visited.
            if (!visited[neighbor]) {
                if (DFS(g, neighbor, visited, v)) {
                    return true; // Return true if a cycle is detected in the subtree.
                }
            } 
            else if (neighbor != parent) {
                return true; 
            }
        }
        return false; // No cycle found
    }

    /**
    * Determine if there is a cycle in the graph. Implement using DFS.
    *
    * @param g the graph to search
    * @return true if there exists at least one cycle in the graph, false otherwise
    */
    public static boolean hasCycle(Graph g) {
        int numVertices = g.numVertices();
        boolean[] visited = new boolean[numVertices];

        // Performs DFS from each vertex
        for (int v = 0; v < numVertices; v++) {
            if (!visited[v]) {
                if (DFS(g, v, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
    * Determine if there is a path between two vertices. Implement using
    * BFS.
    *
    * @param v vertex
    * @param w vertex
    * @param g the graph to search
    * @return true if there is a path between v and w, false otherwise
    */
    public static boolean hasPath(Graph g, int v, int w) {
        // Initialize a boolean array to track visited vertices
    boolean[] visited = new boolean[g.numVertices()];

    // Initializes a queue.
    Queue<Integer> queue = new LinkedList<>();

    queue.add(v);
    visited[v] = true;

    while (!queue.isEmpty()) {
        int current = queue.poll(); // Dequeue a vertex

        // Returns true f the destination vertex 'w' is reached.
        if (current == w) {
            return true;
        }

        // Adds unvisited neighbors to the queue.
        Iterator<Integer> iterator = g.neighbors(current);
        while (iterator.hasNext()) {
            int neighbor = iterator.next();
            if (!visited[neighbor]) {
                queue.add(neighbor);
                visited[neighbor] = true;
            }
        }
    }

    return false;
    }
}
