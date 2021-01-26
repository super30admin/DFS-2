// Time Complexity : o(n)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int numIslands(char[][] grid) {
        Queue<int [] > q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        int island = 0;
        if(grid == null || grid.length == 0) return island;
        int[][] dirs = {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for(int i = 0; i< m ; i++)
        {
            for(int j = 0; j<n ; j++)
            {
                if (grid[i][j] == '1')
                {
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    island++;
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        for(int[] dir: dirs)
                        {
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            if(r>=0 && r< m && c>=0 && c<n && grid[r][c] == '1')
                            {
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                    
                }
            }
            
        }
        return island;
    }
}