package DFS2;

import java.util.LinkedList;
import java.util.Queue;

/*S30 Big N Problem #66 {Medium} - https://www.youtube.com/watch?v=FKmSxpNBj_k&list=PLWtKyKogBpBB3ZUuLAjIlCzZ5bnbult-t&index=22

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:

11110
11010
11000
00000

Output: 1 

Example 2:

Input:
11000
11000
00100
00011

Output: 3

Source Link: https://leetcode.com/problems/number-of-islands/
-------------------------------------------------------------------------------------------------------
BFS Time complexity :  2O(MN)
BFS space complexity: Minimum of rows and column - O(min(M,N)) - the maximum number of nodes going in to the queue will be nodes on diagonal length
DFS Time complexity :  2O(MN)
DFS space complexity:  O(M,N) - recursive stack can have all the nodes inside int the worst case
Did this code run successfully in leetcode : yes
problems faces : no*/
public class NumberOfIslands {
 
    
    Queue<int []> q = new LinkedList<>();
    
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int count =0;
      
        
        int m = grid.length;
        int n = grid[0].length;
                
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    q.add(new int[]{i,j});
                    grid[i][j] = '2';
                    count++;
                    bfs(grid,m,n);
                }
            }
        }
        
        return count;
        
    }
    
    private void bfs(char[][] grid,int m,int n)
    {
        
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        
        
        while(!q.isEmpty())
        {
            int size = q.size();
             int[] curr = q.poll();
             
            for(int[] d : dirs)
            {
                int r = curr[0]+d[0];
                int c = curr[1]+d[1];
                
                if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1')
                {
                    grid[r][c] = '2';
                    q.add(new int[]{r,c});
                }
            
            }
        }
        
    }
    
    
//-----------------------DFS-----------------------------------------------------------------------------------------------------------
 public int numIslandsWithDFS(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
                
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
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
    
    private void dfs(char[][] grid,int i, int j,int m,int n)
    {
        //base 
         if(i<0 || i== m || j<0 || j == n || grid[i][j] != '1') return;

         //logic
         grid[i][j] = '2';
         
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
             
            for(int[] d : dirs)
            {
                int r = i+d[0];
                int c = j+d[1];
                dfs(grid,r,c,m,n);
            }
    }
}
