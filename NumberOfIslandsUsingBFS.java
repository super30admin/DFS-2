package DFS2;
// Time Complexity : O(m*n)  -> 2mn
// Space Complexity : min between m and n
// Did this code successfully run on Leetcode : Yes
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsUsingBFS {

    public int numIslands(char[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++)
        {
            for( int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    q.add(new int[]{i,j});
                    count++;
                    grid[i][j] = '0';

                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        for(int[] dir:dirs)
                        {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1')
                            {
                                q.add(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }

                    }
                }
            }
        }
        return count;
    }


}
