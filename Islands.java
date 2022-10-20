// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*Approach 1 - DFS
 * The approach is to iterate over the entire matrix to find 1 and then perform DFS on it.
 */
public class Islands {
    int [][]dirs;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i = 0; i<m;i++)
        {
            for(int j = 0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    dfs(grid,i,j,m,n);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j,int m,int n)
    {
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0')
        {
            return;
        }
        //logic
        grid[i][j] = '0';
        for(int[] dir:dirs)
        {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            
            dfs(grid,nr,nc,m,n);
        }
    }
}

/*Space Complexity - O(min(m,n))
 * Approach 2 - BFS
 * The idea is to start iterate over the entire matrix and as soon as 1 is encountered, perform BFS on it.
 */
class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
        
        if(grid.length == 0 || grid == null)
        {
            return 0;
        }
        
        dirs = new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        
        for(int i = 0; i<m;i++)
        {
            for(int j = 0; j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    qr.add(i);
                    qc.add(j);
                    grid[i][j] = '0';
                    while(!qr.isEmpty()){
                        int cr = qr.poll();
                        int cc = qc.poll();
                        
                        for(int dir[]: dirs)
                        {
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1')
                            {
                                qr.add(nr);
                                qc.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}
