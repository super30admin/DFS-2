//Time Complexity:O(m × n)- Each cell is visited at most once.
//Space Complexity:O(min(m × n))- Queue size in worst case can be O(m × n) (when the entire grid is filled with land).

//Traverse the grid: For each cell, if it's land ('1'), we’ve found a new island.
//Start BFS from that cell, marking all connected land cells ('1') as visited ('2').
//Increment island count each time a new BFS is triggered.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    q.add(new int[] {i,j});
                    grid[i][j] = '2';
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        for(int[] dir : dirs)
                        {
                            int nr = curr[0]+dir[0];
                            int nc = curr[1]+dir[1];
                            if(nr>=0 && nr<m && nc>=0 &&nc <n && grid[nr][nc]=='1')
                            {
                                grid[nr][nc] = '2';
                                q.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}