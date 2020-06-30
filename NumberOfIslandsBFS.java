// Time Complexity: O(m*n)
// Space Complexity: O(m*n) : all cells are '1'

class Solution{
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length ; int n = grid[0].length;
        int numIslands = 0;
        Queue<int[] > q = new LinkedList<>();

        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                if(grid[i][j] == '1'){
                    numIslands++;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] dir: dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1' ){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }

                        }
                    }

                }

            }
        }
        return numIslands;

    }
}
