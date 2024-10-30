// Time Complexity : O(m*n)
// Space Complexity :O(Min(m,n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : yes. Syntax errors and language c# is different than java
public class Solution {
    public int NumIslands(char[][] grid) {
        int m = grid.Length;
        int n = grid[0].Length;
        int count = 0;
        int[][] dirs = new int[][]{new int[]{-1,0}, new int[]{1,0}, new int[]{0,1}, new int[]{0,-1}};
        Queue<int[]> q = new Queue<int[]>();
        for(int i =0; i<m; i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    q.Enqueue(new int[]{i,j});
                    grid[i][j] = '0';
                    while(q.Count!=0)
                    {
                        int[] curr = q.Dequeue();
                        foreach(int[] dir in dirs)
                        {
                            int r = curr[0]+ dir[0];
                            int c = curr[1]+ dir[1];
                            if(r<m && c<n && r>=0 && c>=0 && grid[r][c]=='1')
                            {
                                q.Enqueue(new int[]{r,c});
                                grid[r][c]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
