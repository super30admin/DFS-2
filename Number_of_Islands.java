import java.util.LinkedList;
import java.util.Queue;

class Solution {
   
	//Approach: BFS
	//1. Here I have counted islands with help of BFS, So I have counted when am facing an '1', and then doing BFS using queue and added all the neighbors in 4 directions.
	//2. While adding to the queue, am changing the 1 to 0, that way we can keep a count of visited islands. We will add all the nodes with 1 to the queue that way we will process,
	//all its neighbors, and then marking them and adding them to the queue.  
	//3. Return the matrix after processing all the nodes in queue.
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                       // System.out.println(i+"--"+j);
                        for(int[] dir: directions)
                        {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r >=0 && c >=0 && r < m && c < n && grid[r][c] == '1')
                            {
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }   
                        }
                    }
                }
            }
        }     
        return count;
    }
    
}
//Time Complexity : O(m*n) 
//Space Complexity : O(m*n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :