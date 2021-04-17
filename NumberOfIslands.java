//Depth First Search - BFS
//Time - O(M x N) - M- no of rows, N - no of cols
//Space - worst case O(M x N) - M- no of rows, N - no of cols
//         in case the grid is filled with all 1s, that many times recursion

class Solution {
  public int numIslands(char[][] grid) {

    if(grid == null || grid.length == 0){
      return 0;
    }

    int count = 0;

    for(int i=0; i<grid.length; i++){
      for(int j=0; j<grid[0].length; j++){
        if(grid[i][j] == '1'){
          count++;
          checkTheIsland(grid, i, j);
        }
      }
    }
    return count;
  }

  public void checkTheIsland(char[][] grid, int i, int j){
    if(i < 0 || i>= grid.length || j < 0 || j>= grid[0].length || grid[i][j] == '0'){
      return;
    }

    grid[i][j] = '0';

    checkTheIsland(grid, i+1, j);
    checkTheIsland(grid, i-1, j);
    checkTheIsland(grid, i, j+1);
    checkTheIsland(grid, i, j-1);
  }
}



//Depth First Search - DFS
//Time - O(M x N) - M- no of rows, N - no of cols
//Space - worst case O(M x N) - M- no of rows, N - no of cols
//         in case the grid is filled with all 1s, that many times recursion

// start with the i,j coord if it has '1'
// put this coord into the queue
// iterate till the queue is empty() - initialize dirs[] and poll index[]
// check if it contains '1' - replace its value to '0' (like visited)
// add it to the queue
class Solution {
  public int numIslands(char[][] grid) {

    if(grid == null || grid.length == 0){
      return 0;
    }

    int count = 0;
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> queue = new LinkedList<>();

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(grid[i][j] == '1'){
          count++;
          grid[i][j] = '0';
          queue.add(new int[]{i,j});

          while(!queue.isEmpty()){

            int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
            int[] coord = queue.poll();

            for(int[] dir: dirs){

              int r = coord[0]+dir[0];
              int c = coord[1]+dir[1];

              if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                grid[r][c] = '0';
                queue.add(new int[]{r,c});
              }
            }
          }
        }
      }
    }


    return count;
  }
}