package CountTheNumberOfCompleteComponents;

// https://leetcode.com/problems/count-the-number-of-complete-components/

import java.util.ArrayList;
import java.util.List;

class Solution {
    // Time: O(V + E)
    // Space: O(V + E)
    public int countCompleteComponents(int n, int[][] edges) {
        // Initialize the adjacency list of the graph.
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the adjacency list.
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Initialize the visited array and the result.
        boolean[] visited = new boolean[n];
        int res = 0;

        // Loop over all the nodes to get all the components in the graph.
        for (int i = 0; i < n; i++) {
            // If the current node is visited, skip it.
            if (!visited[i]) {
                // Get the component the current node belongs to using DFS.
                List<Integer> comp = dfs(i, new ArrayList<>(), adj, visited);

                // In a complete component with m nodes, each node will have m-1 edges
                // to connect it with the rest of the nodes. Thus, we will check if all
                // the nodes in the component have m-1 edges.
                boolean flag = true;
                for (int node : comp) {
                    // If a single node doesn't have m-1 edges, the component can't be
                    // a complete component, so break out of the loop.
                    if (adj.get(node).size() != comp.size() - 1) {
                        flag = false;
                        break;
                    }
                }

                // If all the nodes in the component have m-1 edges, increment the result.
                if (flag) {
                    res++;
                }
            }
        }

        return res;
    }

    // DFS to find all nodes in the connected component.
    private List<Integer> dfs(int v, ArrayList<Integer> res, List<List<Integer>> adj, boolean[] visited) {
        // Return an empty list if v is already visited.
        if (visited[v]) {
            return List.of();
        }

        // Mark v as visited and add it to the component list.
        visited[v] = true;
        res.add(v);

        // Recur for all its connected neighbors.
        for (int nei : adj.get(v)) {
            dfs(nei, res, adj, visited);
        }

        // Return the component's nodes.
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.countCompleteComponents(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 4}
                        }
                )
        );

        System.out.println(
                sol.countCompleteComponents(
                        6,
                        new int[][]{
                                {0, 1},
                                {0, 2},
                                {1, 2},
                                {3, 4},
                                {3, 5}
                        }
                )
        );
    }
}