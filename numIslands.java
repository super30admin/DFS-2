//Time Complexity:O(N) where N will be M*N which is the size of the grid.
//Space Complexity:O(N)
//In this problem, I'll count the number of Islands in a recursive manner. In the recursive function, I'll check the boundary conditions, along with checking if the encountered character is 0. In all these cases, I'll return 0. Else, if i have encountered a 1, I'll make it 0, so that which backtracking, I'll not be counting it again. After that, I'll check all 4 directions(top, left, bottom and right) and keep on doing it until I violate the boundary conditions. I'll be returning 1 in this case, if I can form an island. 
//This code was executed successfully and got accepted in leetcode.

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        int numIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                numIslands+=dfs(grid,i,j);
            }
        }
        return numIslands;
    }
    private int dfs(char[][]grid,int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]=='0'){
            return 0;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);//top
        dfs(grid,i+1,j);//bottom
        dfs(grid,i,j-1);//left
        dfs(grid,i,j+1);//right
        return 1;
    }
}