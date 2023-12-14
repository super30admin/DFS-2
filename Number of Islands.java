// Time Complexity :O(M*N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        //DFS

        int count=0;
        for(int i=0; i<grid.length;i++)
        {
            for(int j=0; j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    helper(grid,i,j);
                    count++;
                }
            }
        }
        return count;

        }
        public void helper(char[][] grid, int i, int j)
        {
            if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]=='1')
            {
                grid[i][j]='0';

                helper(grid,i+1,j);
                helper(grid,i-1,j);
                helper(grid,i,j+1);
                helper(grid,i,j-1);

                return;
            }

        

        //BFS
        // Queue<int[]> q= new LinkedList<>();
        // int count=0;
        // int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        
        // for(int i=0;i<grid.length;i++)
        // {
        //     for(int j=0; j<grid[0].length;j++)
        //     {
        //         if(grid[i][j]=='1')
        //         {
        //             count++;
        //             grid[i][j]='0';
        //             q.add(new int[]{i,j});

        //             while(!q.isEmpty())
        //             {
        //                 int[] curr = q.poll();

        //                 for(int[] dir:dirs)
        //                 {
        //                     int r=curr[0]+dir[0];
        //                     int c=curr[1]+dir[1];

        //                     if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]=='1')
        //                     {
        //                         grid[r][c]='0';
        //                         q.add(new int[]{r,c});
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
        // return count;
    }
}