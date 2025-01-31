// Approach 1: BFS
// TC: O(N*M)
// SC: O(N*M), worst case queue size and visited matrix

// Approach 2: DFS
// TC: O(N*M)
// SC: O(N*M), worst case recursive stack and visited matrix

// where N is the number of rows and M is the number of columns in the input matrix

import java.util.LinkedList;
import java.util.Queue;

// Approach 1: BFS
public class LC200 {
    private class Pair {
        private int first;
        private int second;

        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    int[] s1 = new int[] { 1, -1, 0, 0 };
    int[] s2 = new int[] { 0, 0, 1, -1 };

    public void bfs(int i, int j, char[][] grid, int[][] visited) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(i, j));
        visited[i][j] = 1;
        int N = grid.length;
        int M = grid[0].length;
        while (!q.isEmpty()) {
            Pair val = q.poll();
            for (int ind = 0; ind < 4; ind++) {
                int x = val.first + s1[ind], y = val.second + s2[ind];
                if (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '1' && visited[x][y] == 0) {
                    q.add(new Pair(x, y));
                    visited[x][y] = 1;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int count = 0;
        int visited[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    bfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
}

// Approach 2: DFS
class LC200_1 {
    int[] s1 = new int[] { 1, -1, 0, 0 };
    int[] s2 = new int[] { 0, 0, 1, -1 };

    public void formIsland(int i, int j, char[][] grid, int[][] visited) {
        visited[i][j] = 1;
        int N = grid.length;
        int M = grid[0].length;
        for (int ind = 0; ind < 4; ind++) {
            int x = i + s1[ind], y = j + s2[ind];
            if (x >= 0 && x < N && y >= 0 && y < M && grid[x][y] == '1' && visited[x][y] == 0) {
                formIsland(x, y, grid, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int count = 0;
        int visited[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    count++;
                    formIsland(i, j, grid, visited);
                }
            }
        }
        return count;
    }
}