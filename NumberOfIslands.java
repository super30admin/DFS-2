// edge cases : if we are on the first/last row/column
// constraints :  none
// technique: dfs and bfs

/*
    bfs -> mark the visited nodes of 1 as 0 and incremenet the number of islands
    dfs -> similarly do the above the previous path is not revisiting the node again

    time complexity : O(mxn)
    sc: O(mxn)

    Define the structure of the code : BFS
     1. Declare Queue of positions (0,0)
     2. if the given node value is 1 increment island value and then
         make it 0 and add the adjacent direction position to the queue
     3. if the given node value is 0 then continue 
     4. there will be a for loop going over the values in the array and then doing the above

    Define the structure: DFS
     1. build the recursive stack and navigate into all directions and return if the coordinate is beyond the edge

     why is dfs faster than bfs? 
     - DFS is often faster for this problem due to its lower 
     overhead from simpler stack operations and the way it handles connected 
     components. However, the difference is usually marginal, 
     and for very large grids or specific grid shapes, 
     BFS could perform comparably or even better in certain situations. 
     The choice often comes down to the specific grid configuration and implementation details.
*/

class Solution {

  int num_islands;

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (m == 0 || n == 0) return 0;

    //dfs
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          num_islands++;
          dfs(grid, i, j);
        }
      }
    }
    return num_islands;
  }

  public void dfs(char[][] grid, int i, int j) {
    //base
    if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
      return;
    }
    if (grid[i][j] == '0') return;

    //logic
    grid[i][j] = '0';

    dfs(grid, i + 1, j);
    dfs(grid, i - 1, j);
    dfs(grid, i, j + 1);
    dfs(grid, i, j - 1);
  }
}

//bfs
class Solution {

  public int numIslands(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (m == 0 || n == 0) return 0;

    //bfs -> using queue -> queue of nodes
    Queue<Pair<Integer, Integer>> q = new LinkedList<>();
    int num_island = 0;

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          num_island++;
          q.add(new Pair<>(i, j));
          grid[i][j] = '0';

          while (!q.isEmpty()) {
            //check for all adjacent points and make them 0
            Pair<Integer, Integer> c = q.poll();
            int s = c.getKey();
            int e = c.getValue();

            //left
            if (s - 1 >= 0 && grid[s - 1][e] == '1') {
              q.add(new Pair<>(s - 1, e));
              grid[s - 1][e] = '0';
            }
            //right
            if (s + 1 < m && grid[s + 1][e] == '1') {
              q.add(new Pair<>(s + 1, e));
              grid[s + 1][e] = '0';
            }
            //top
            if (e - 1 >= 0 && grid[s][e - 1] == '1') {
              q.add(new Pair<>(s, e - 1));
              grid[s][e - 1] = '0';
            }
            //bottom
            if (e + 1 < n && grid[s][e + 1] == '1') {
              q.add(new Pair<>(s, e + 1));
              grid[s][e + 1] = '0';
            }
          }
        }
      }
    }
    return num_island;
  }
}
