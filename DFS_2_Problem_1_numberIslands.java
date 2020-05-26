//Time Complexity : O(m*n) We might need to traverse through the whole matrix
//Space Complexity : O(1)
//Runs successfully on leetcode
//No problem

//We will start traversing the whole matrix, if we see 1 (part of island) we will apply dfs on it and add 1 to total islands
//In the end we will return total value of islands

public class DFS_2_Problem_1_numberIslands {
    char cur = '1';
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;



        int total = 0;
        for(int i = 0; i<m ; i++)
        {
            for(int j = 0 ; j<n; j ++)
            {
                if(grid[i][j] == '1')
                {
                    dfs(grid,i,j);
                    total++;
                }
            }
        }

        return total;


    }
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    public void dfs(char[][] grid,int i,int j)
    {
        grid[i][j] = '0';
        for(int[] d : dirs)
        {
            int r = i + d[0];
            int c = j + d[1];
            if(r>=0 && r<grid.length && c >=0 && c<grid[0].length && grid[r][c] != '0')
            {
                dfs(grid,r,c);
            }
        }
    }
}
