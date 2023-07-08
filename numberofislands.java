// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
// we are iterating through the array and when we find 1 .. we are incrementing the value of count, making the value to 0 (water)
// and starting an BFS/DFS over there so that all the connected nodes are checked and if the connected node is 1 (land) we change its value to 0
// and add it to the queue.


class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        int dirs[][]= new int[][]{{1,0},{0,1}, {0,-1}, {-1,0}};
        int count=0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    q.add(new int[]{i,j});
                    grid[i][j]='0';
                    while(!q.isEmpty())
                    {
                        int curr[] = q.poll();
                        //level
                        for(int[] dir: dirs)
                        {
                            int nr=curr[0]+dir[0];
                            int nc=curr[1]+dir[1];
                            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1')
                            {
                                    q.add(new int[]{nr,nc});
                                    grid[nr][nc]='0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}