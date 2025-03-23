package NumberOfWaysToArriveAtDestination;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

import java.util.*;

// Use a modified version of the Dijkstra's algorithm to store the count of
// paths we can reach each node along with the cost of the shortest path.
class Solution {
    // Time: O((V + E) * log V)
    // Space: O(V + E)
    public int countPaths(int n, int[][] roads) {
        // Build the adjacency list to store the graph where each node
        // stores an array of (weight, neighbor).
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add a bidirectional edge for each two nodes, because this is an undirected graph.
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[2], road[1]});
            adj.get(road[1]).add(new int[]{road[2], road[0]});
        }

        // Modulo for large numbers to prevent overflow.
        int mod = 1_000_000_007;

        // Min-heap to store (cost, node), used for Dijkstra's algorithm.
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        // Store the minimum cost to reach each node. Initialize with a
        // large value and try to minimize it.
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE);

        // Store the number of ways to reach each node with the shortest
        // path. Initially, no paths for all nodes.
        long[] pathCount = new long[n];
        Arrays.fill(pathCount, 0);

        // Start Dijkstra's algorithm from node 0, which doesn't need any
        // cost to reach it, and there is only a single way to it.
        minHeap.add(new long[]{0, 0});
        minCost[0] = 0;
        pathCount[0] = 1;

        while (!minHeap.isEmpty()) {
            // Get the node with the smallest cost.
            long[] cur = minHeap.poll();
            long cost = cur[0];
            int node = (int) cur[1];

            // Process all its neighbors.
            for (int[] nei : adj.get(node)) {
                int neiCost = nei[0], neiNode = nei[1];

                // Calculate the new cost to reach the neighbor through the current node.
                long newNeiCost = cost + neiCost;

                // Check if we found a new smaller path, or the same as the old
                // minimum path to update the count.
                if (newNeiCost < minCost[neiNode]) {
                    // Found a new shorter path to the neighbor, so the count is reset,
                    // and the node is added to the heap to process its neighbors.
                    minCost[neiNode] = newNeiCost;
                    pathCount[neiNode] = pathCount[node];
                    minHeap.add(new long[]{newNeiCost, neiNode});
                } else if (newNeiCost == minCost[neiNode]) {
                    // Found another way to reach the neighbor with the same old
                    // shortest path cost, so update the count we have so far.
                    pathCount[neiNode] = (pathCount[neiNode] + pathCount[node]) % mod;
                }
            }
        }

        // Return the number of ways to reach the last node.
        return (int) pathCount[n - 1];
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.countPaths(
                        7,
                        new int[][]{
                                {0, 6, 7},
                                {0, 1, 2},
                                {1, 2, 3},
                                {1, 3, 3},
                                {6, 3, 3},
                                {3, 5, 1},
                                {6, 5, 1},
                                {2, 5, 1},
                                {0, 4, 5},
                                {4, 6, 2}
                        }
                )
        );

        System.out.println(
                sol.countPaths(
                        2,
                        new int[][]{
                                {1, 0, 10}
                        }
                )
        );
    }
}