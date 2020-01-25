//DFS
/***************** Time Complexity: O(m*n) ****************** */
/***************** Space Complexity: O(mn) ****************** */

class Solution {
    
    public int numIslands(char[][] grid) {
        //base case
        if(grid == null)
            return 0;

        //initialize count of islands to 0
        int islands = 0;

        //iterate over the grid to search for island
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                //if land exists
                if(grid[i][j]=='1'){
                    //call dfs function (countIslands) for i,j
                    countIslands(i,j,grid);
                    islands++;
                }
                //else no operation needed
                //return 0 as the island count
            }
        }
        return islands;
    }
    
    public void countIslands(int i, int j, char[][] grid){
        //base case
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length ) {
            if(grid[i][j] == '1') {
                //making any of the children of the node as 0
                grid[i][j]='0';
                //recursively calling the function for every direction of the grid
                //and making them 0 each time
                countIslands(i+1,j,grid);
                countIslands(i-1,j,grid);
                countIslands(i,j+1,grid);
                countIslands(i,j-1,grid);
                //recursion flows back after every neighbor is made 0
                //reaches to the starting point
            }
        }
    }
}