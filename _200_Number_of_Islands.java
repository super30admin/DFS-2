/**** Method 1 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//Using DFS to solve this problem, as we want to find island, we start by traversing the given gird and if we find a '1', we increase the count of island and do a DFS to mark it territory as visited ('1' to '2'), we traverse to all it's neighbors and update their values. Then we continue the grid traversal.

/**** Method 2 ****/
//Time Complexity: O(n*m)
//Space Complexity: O(n*m)

//Successfully submitted in LeetCode

//Using BFS to solve this problem, same as above but here we just BFS instead of DFS to mark the island territory visited and also we update the values before adding to queue.

import java.util.LinkedList;
import java.util.Queue;

public class _200_Number_of_Islands {

  /**** Method 1 ****/
  public int numIslandsDFS(char[][] grid) {
    int n = grid.length - 1;
    int m = grid[0].length - 1;
    int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          dfs(i, j, n, m, grid, dir);
        }
      }
    }

    return count;
  }

  private void dfs(int i, int j, int n, int m, char[][] grid, int dir[][]) {
    grid[i][j] = '2';

    for (int neigh[] : dir) {
      int nr = i + neigh[0];
      int nc = j + neigh[1];

      if (nr >= 0 && nr <= n && nc >= 0 && nc <= m && grid[nr][nc] == '1') {
        dfs(nr, nc, n, m, grid, dir);
      }
    }
  }

  /**** Method 2 ****/
  public int numIslandsBFS(char[][] grid) {
    int n = grid.length - 1;
    int m = grid[0].length - 1;
    int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          count++;
          bfs(i, j, n, m, grid, dir);
        }
      }
    }

    return count;
  }

  private void bfs(int i, int j, int n, int m, char[][] grid, int dir[][]) {
    Queue<int[]> que = new LinkedList<>();
    grid[i][j] = '2';
    que.add(new int[] { i, j });
    while (!que.isEmpty()) {
      int polled[] = que.poll();
      for (int neigh[] : dir) {
        int nr = polled[0] + neigh[0];
        int nc = polled[1] + neigh[1];

        if (nr >= 0 && nr <= n && nc >= 0 && nc <= m && grid[nr][nc] == '1') {
          grid[nr][nc] = '2';
          que.add(new int[] { nr, nc });
        }
      }
    }
  }
}
