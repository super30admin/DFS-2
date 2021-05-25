class Solution {
    //Time O(m*n)
    //Space O(MIN(m,n))
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        int count = 0;
        for(int i=0 ; i<grid.length ; i++)
        {
            for(int j=0 ; j<grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    BFS(grid , i , j);
                }
                
            }
        }
        return count;
    }
    public void BFS(char[][] grid , int i ,int j)
    {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] {i,j});
        while(!Q.isEmpty())
        {
            int curr[] =  Q.poll();
            for(int[] dir : dirs)
            {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != '0')
                {
                    grid[r][c] = '0';
                    Q.add(new int[] {r,c});
                }
            }
        }
    }
}