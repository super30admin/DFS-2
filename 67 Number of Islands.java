// Time Complexity : O(m*n)
// Space Complexity :0(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int numIslands(char[][] grid) {
        //aesha
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i =0;i<m;i++)
        {
            for(int j =0; j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        for(int[] dir: dirs)
                        {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1' )
                            {
                                q.add(new int[]{r,c});
                                grid[r][c]= '0';
                            }
                        }
                    }

                }
            }
        }
        return count;
    }
}