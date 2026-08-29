//Time Complexity:  O(mxn)
//Space Complexity: O(m) or O(n) depending on Minimum between m and n
class Solution {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {

        this.m = grid.length;
        this.n = grid[0].length;
        this.dirs = new int[][] {{-1,0}, {1, 0}, {0,1}, {0,-1}};
        int count = 0;
        for(int i=0; i <m ; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    private void helper(char[][] grid, int i, int j)
    {
        //Base Case                                                                        
        if( i < 0 || i > m-1 || j < 0 || j > n-1 || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        for(int[] dir: dirs)
        {
            int r = dir[0] + i;
            int c = dir[1] + j;
            helper(grid, r, c);
        }
    }
}