//time : O(m*n) where m and n are the rows and cols
// space: O(h) where h is the height of the recursion stack

class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                if(grid[row][col] == '1'){
                    grid[row][col] = '#';
                    count += 1;
                    helper(row,col,grid);
                }
            }
        }

        return count;

    }


    public void helper(int row, int col, char[][] grid){
        if(grid[row][col] == '0') return;


        if(isValid(row,col+1,grid)){
            grid[row][col+1] = '#';
            helper(row,col+1,grid);
        }
        if(isValid(row+1,col,grid)){
            grid[row+1][col] = '#';
            helper(row+1,col,grid);
        }
        if(isValid(row,col-1,grid)){
            grid[row][col-1] = '#';
            helper(row,col-1,grid);
        }
        if(isValid(row-1,col,grid)){
            grid[row-1][col] = '#';
            helper(row-1,col,grid);
        }

    }


    public boolean isValid(int row, int col, char[][] grid){
        boolean res =  row >= 0 && row < grid.length && col >=0 && col < grid[0].length
            && grid[row][col] == '1';
        return res;
    }
}
