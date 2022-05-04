// Time Complexity : O(N*M)
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

public class NumberOfIslands{


    public static int m,n;
   public static  int[][] dirs;
    public static int numIslands(char[][] grid) {
        
        if(grid == null)
        {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        
        dirs = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        
        int total=0;
        //Queue<int[]> q = new LinkedList<>();
        
        for(int i =0;i<m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    total++;
                }
            }
        }
        
        return total;    
    }
    
    private static void dfs(char[][] grid, int r, int c)
    {
        if(r<0 || c<0 || r==m || c == n || grid[r][c]!= '1') return;
        
        grid[r][c] = '0';
        for(int[] dir: dirs)   
        {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            dfs(grid,nr,nc);
        }
    }

}