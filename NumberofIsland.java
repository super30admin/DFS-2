
class NumberofIsland {

    // Time Complexity : O(MxN)
    // Space Complexity : O(MxN)
    // Did this code successfully run on Leetcode : NO
    // Any problem you faced while coding this : I was comparing Integer 1 vs Char 1 so it was failing.

    int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
   int m = 0;
   int n = 0;
   int count = 0;
   public int numIslands(char[][] grid) {

       if(grid == null || grid.length == 0) return 0;
       m = grid.length;
       n = grid[0].length;
       count = 0;
       directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

       for(int i = 0; i< grid.length; i++){
           for(int j = 0; j < grid[0].length; j++){
               if(grid[i][j] == '1'){
                   // initiate Dfs
                   count++;
                   dfs(grid, i, j);

               }
           }
       }

       return count;
   }

   private void dfs(char[][] grid, int r, int c){
     //base
     if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '1'){
       return;
     }

     // logic
     grid[r][c] = "-".charAt(0);

       for(int[] dir : directions){
           int new_r = dir[0] + r;
           int new_c = dir[1] + c;
           dfs(grid,new_r,new_c);
       }
     }

    // Time Complexity : O(MxN)
    // Space Complexity : O(MxN)
    // Did this code successfully run on Leetcode : NO
    // Any problem you faced while coding this : I was comparing Integer 1 vs Char 1 so it was failing.



    public int numIslandsBFS(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    // initiate bfs
                    System.out.printf("row %d | col %d\n", i ,j);
                    count++;
                    Queue<int []> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int row = curr[0];
                        int col = curr[1];

                        for(int[] dir : directions){
                            int r = dir[0] + row;
                            int c = dir[1] + col;

                            if(r >= 0 && r < m && c >=0 && c < n && grid[r][c] == '1'){
                                grid[r][c] = "-".charAt(0);
                                q.add(new int[]{r,c});
                            }
                        }
                    }

                }

               // System.out.print(grid[i][j]);

            }
            //System.out.println();
        }

        return count;
    }
}
