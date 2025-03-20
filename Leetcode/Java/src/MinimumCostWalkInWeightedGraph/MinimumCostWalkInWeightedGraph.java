package MinimumCostWalkInWeightedGraph;

// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

import static utils.ArrayUtils.printArray;

// When we use the AND operation with two values x and y, it results in a value z that is smaller
// than both x and y. In the best case scenario, when we use it with equal values x and x, it
// results in x also.
// X = 0 1 1 1 -> 7
// Y = 1 0 1 1 -> 11
// Z = 0 0 1 1 -> 3, which is smaller than 7 and 11.

// We have node 3 facts now:
//      1. This property of AND operation.
//      2. We can visit the same node multiple times.
//      3. The formula of the path cost (bitwise AND of all the weights of the path).
// Thus, we are sure that the minimum value to visit any node in the graph will be visiting all the
// nodes in the graph to take the longest path that includes all the weights. This is because the
// overall cost of the path will be smaller than the minimum weight in the graph, and this is what
// we need.

// So the result of any query between two nodes would be the bitwise AND of all the weights in the
// component they belong to. Note that the graph can have multiple components, so there might be
// some queries that can't happen. But other than that, we will preprocess the weights of each
// component and store the bitwise AND of all the weights in each one of them.

// To process any query, see if both nodes belong to the same component or not. If they belong
// to the same component, return its saved value, and if not, return -1.

// --------------------------------------------------------------------------------------------------
// Both solutions are the same, but the fist one process the weights in the Union Find class. In the
// `union` function, we update the weights of each component to get rid of the second step and the map.

// Used to manage the connected components efficiently.
class UnionFind {
    // Store the parent of each node. If a node is its own parent, it is a root node.
    int[] parent;
    // Store the size of each component for the union by size optimization.
    int[] size;
    // Store the cost of each component.
    int[] cost;

    public UnionFind(int n) {
        // Initialize each node as its own parent, meaning each node is its own component.
        parent = IntStream.range(0, n).toArray();

        // Each component starts with size 1, as every node starts as an independent component.
        size = new int[n];
        Arrays.fill(size, 1);

        // Initialize each component cost with -1.
        cost = new int[n];
        Arrays.fill(cost, 0xFFFFFFF);
    }

    // Recursively finds the root of x by updating the parent pf x to point directly to the
    // root, which speeds up future queries. This takes around O(1) due to path compression.
    public int find(int x) {
        if (x != parent[x]) {
            // Path compression.
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Connect two nodes in a single component. This takes around O(1).
    public void union(int x, int y, int w) {
        // Finds the root of x and y.
        int p1 = find(x);
        int p2 = find(y);

        // If both roots are equal (they belong to the same component), update
        // the cost of the parent only.
        if (p1 == p2) {
            cost[p1] &= w;
            return;
        }

        // If they belong to different sets, union them.
        // Attach the smaller tree to the larger one, update the size, and the weight.
        if (size[p1] < size[p2]) {
            parent[p1] = p2;
            size[p2] += size[p1];
            cost[p2] &= cost[p1];
            cost[p2] &= w;
        } else {
            parent[p2] = p1;
            size[p1] += size[p2];
            cost[p1] &= cost[p2];
            cost[p1] &= w;
        }
    }
}

class Solution {
    // Time: O(E + Q), where E is the number of edges, and Q is the number of queries.
    // Space: O(n)
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // 1. Get the connected components.
        // Create the Union-Find structure for n nodes.
        UnionFind uf = new UnionFind(n);

        // Processes all edges to form connected components.
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }

        // 2. Process the queries.
        // Initialize the result array.
        int size = query.length;
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            // Find the root of both nodes in the query.
            int root1 = uf.find(query[i][0]);
            int root2 = uf.find(query[i][1]);

            // If they belong to different components, add -1 to the result. If they belong to
            // the same component, add the stored minimum cost to the result.
            if (root1 != root2) {
                res[i] = -1;
            } else {
                res[i] = uf.cost[root1];
            }
        }

        // Return the result.
        return res;
    }
}

/*// Used to manage the connected components efficiently.
class UnionFind {
    // Store the parent of each node. If a node is its own parent, it is a root node.
    int[] parent;
    // Store the size of each component for the union by size optimization.
    int[] size;

    public UnionFind(int n) {
        // Initialize each node as its own parent, meaning each node is its own component.
        parent = IntStream.range(0, n).toArray();

        // Each component starts with size 1, as every node starts as an independent component.
        size = new int[n];
        Arrays.fill(size, 1);
    }

    // Recursively finds the root of x by updating the parent pf x to point directly to the
    // root, which speeds up future queries. This takes around O(1) due to path compression.
    public int find(int x) {
        if (x != parent[x]) {
            // Path compression.
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    // Connect two nodes in a single component. This takes around O(1).
    public void union(int x, int y) {
        // Finds the root of x and y.
        int p1 = find(x);
        int p2 = find(y);

        // If they belong to different sets, union them. And if they are already
        // connected, do nothing.
        if (p1 != p2) {
            // Attach the smaller tree to the larger one, and update the size.
            if (size[p1] < size[p2]) {
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
}

class Solution {
    // Time: O(E + Q), where E is the number of edges, and Q is the number of queries.
    // Space: O(n)
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // 1. Get the connected components.
        // Create the Union-Find structure for n nodes.
        UnionFind uf = new UnionFind(n);

        // Processes all edges to form connected components.
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        // 2. Get the cost of each component.
        // Store the root of each component, and map it to the cost.
        HashMap<Integer, Integer> componentCost = new HashMap<>();

        for (int[] edge : edges) {
            // Get the root of this component.
            int root = uf.find(edge[0]);

            // If the root wasn't computed before, just add the weight of this edge. If it was
            // already added, bitwise AND its old value with this edge weight.
            if (!componentCost.containsKey(root)) {
                componentCost.put(root, edge[2]);
            } else {
                componentCost.put(root, componentCost.get(root) & edge[2]);
            }
        }

        // 3. Process the queries.
        // Initialize the result array.
        int size = query.length;
        int[] res = new int[size];

        for (int i = 0; i < size; i++) {
            // Find the root of both nodes in the query.
            int root1 = uf.find(query[i][0]);
            int root2 = uf.find(query[i][1]);

            // If they belong to different components, add -1 to the result. If they belong to
            // the same component, add the stored minimum cost to the result.
            if (root1 != root2) {
                res[i] = -1;
            } else {
                res[i] = componentCost.get(root1);
            }
        }

        // Return the result.
        return res;
    }
}*/

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        printArray(
                sol.minimumCost(
                        5,
                        new int[][]{
                                {0, 1, 7},
                                {1, 3, 7},
                                {1, 2, 1}
                        },
                        new int[][]{
                                {0, 3},
                                {3, 4}
                        }
                )
        );

        printArray(
                sol.minimumCost(
                        3,
                        new int[][]{
                                {0, 2, 7},
                                {0, 1, 15},
                                {1, 2, 6},
                                {1, 2, 1}
                        },
                        new int[][]{
                                {1, 2}
                        }
                )
        );
    }
}