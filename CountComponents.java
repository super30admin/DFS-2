/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to find the number of connected
 * components in an undirected graph.
 * 
 * Idea:
 * Create graph from edges, and then call dfsVisit for unvisited nodes of the graph, the number of calls equals number of components.
 * 
 * Space Complexity: O(V+E)
 * Time Complexity: O(V+E)
 * 
 * Leetcode Result:
 * 
 * Runtime: 7 ms, faster than 34.86% of Java online submissions for Number of Connected Components in an Undirected Graph.
 * Memory Usage: 44.5 MB, less than 63.64% of Java online submissions for Number of Connected Components in an Undirected Graph.
 * 
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new LinkedList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsVisit(graph, i, visited);
                components++;
            }
        }

        return components;
    }

    private void dfsVisit(Map<Integer, List<Integer>> graph, int u, boolean[] visited) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfsVisit(graph, v, visited);
            }
        }
    }
}