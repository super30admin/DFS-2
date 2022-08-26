import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    int m;
    int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        
        if(grid == null) return 0;
         m = grid.length;
         n = grid[0].length;
        dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        for(int i=0; i<m ; i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                   count++;
                   //bfs(grid,i,j); 
                   dfs(grid,i,j);
                }
                
            }
        }
        return count;
    }
    
    /*bfs approach: ALL
    we run bfs for each island, to mark it as visited we mark grid lelement as 0
    1. we start from element where we encounter a 1, since we found an island we increment our count by 1
    2. we would go to all immediate neighbors and mark them as 0 and then process the neighbours for their neighbours.
    Time: O(mn)  since worst if all elements are 1's bfs would make everything 0 so no bfs would be called in the second turn.
    Space: max(m,n), max elements in queue would be max of m and n
    
    */
    public void bfs(char[][] grid, int row, int col)
    {
     
        //inserting 2 elements at a time for row and column
        Queue<Integer> queue=new LinkedList<>();
        queue.add(row);
        queue.add(col);
        
        while(!queue.isEmpty())
        {
            int currRow = queue.poll();
            int currCol = queue.poll();
            
            for(int[] dir:dirs)
            {
                int nr = currRow + dir[0];
                int nc = currCol + dir[1];    
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]!='0')
                {
                    grid[nr][nc] = '0';
                    queue.add(nr);
                    queue.add(nc);
                      
                }
                                    
            }
            
            
        }  
        
    }
    
    
    /*
    dfs: Any
    1. Outer loop takes us to an island ('1') where we perform a fresh dfs and increment our count by 1
    1. we find '1' for an island and process any one of it's children at once until we have covered the whole island.   
     Time: O(mn)  since worst if all elements are 1's bfs would make everything 0 so no bfs would be called in the second turn.
    Space: O(mn) when all elements are in the stack
    */
    
    public void dfs(char[][] grid, int row, int col)
    {
        //base
        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == '0') return;
        
        //logic
        
        grid[row][col] = '0';
        for(int[] dir: dirs)
        {
            int nr = row + dir[0];
            int nc = col + dir[1];
           
            dfs(grid, nr, nc);
                        
        }
    }

}