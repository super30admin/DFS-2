//TC:O(mxn)
//SC:O(mXn)
//Successfully ran on leetcode
class Solution {
    public int numIslands(char[][] grid)
    {
        int count = 0;

        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                //System.out.println(grid[i][j]);
                if(grid[i][j] == '1')
                {
                    bfs(grid,i,j);
                    count+=1;
                }
            }
        }

	return count;
    }

    private void bfs(char[][] grid,int i, int j)
    {
        if(grid[i][j] == '0')
			return;

		grid[i][j] = '0';

        int[][] dirs={{0,-1},{-1,0},{0,1},{1,0}};

        for(int[] dir: dirs)
        {
            int x=i+dir[0];
            int y=j+dir[1];

            if(x<0 || y<0 || x>=grid.length ||y>=grid[0].length)
                continue;
            bfs(grid,x,y);
        }

    }

}
