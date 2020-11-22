//Time complexity: O(mn)  => O(N)
//Space Complexity: O(mn)=> O(N) recursive so stack so N space
//Ran on leetcode and accepted
class Solution 
{
    //directions to be checked for neighbor islands
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int numIslands(char[][] grid) 
    {
        //If the grid is empty return 0 islands
        if(grid.length ==0 || grid ==null)
        {
            return 0;
        }
        //initialise islands as 0 and set flag as 1
        int islands = 0;
        int flag = 1;
        //Traverse the matrix
        for(int i = 0; i<grid.length;i++)
        {
            for (int j=0 ; j< grid[0].length; j++)
            {
                //If the value is 1
                if(grid[i][j] == '1')
                {
                    //Check its neighbors for islands (dfs) and increment islands
                    islands+=neighborislands(grid,i,j);
                }
               
            }
        }
        //return number of islands 
        return islands;
    }
    
    //function to check for neighbors
    public int neighborislands(char[][] grid,int i,int j)
    {
        //check if the coordinates have gone out of bounds or if the value is 0 or water   
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0')
            //return 0
            return 0;
        //flip the grid to 0 so that we dont double count the grid
        grid[i][j] = '0';
        //Check for each direction
        for(int[] d:dir)
        {
            //call the dfs recursively for all directions
            neighborislands(grid,i+d[0],j+d[1]);
        }
        //return 1
        return 1;
    }
}