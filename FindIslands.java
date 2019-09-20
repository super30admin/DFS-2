/*
Author: Akhilesh Borgaonkar
Problem: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
Approach: I have used DFS approach here. I am exploring the input grid to find '1' and then calling dfs function to explore its neighbors.
    While visiting the neighbors I am marking those cells as '0' to avoid revisiting them again. While in dfs function, I check for edge cases of grid coordinates
    and if the cell has '1' char then mark it as '0'.
Time complexity: O(R*C) where R and C are number of rows and columns in grid respectively.
Space complexity: Constant - O(R*C) where R and C are number of rows and columns in grid respectively.
Issues faced: First I thought of using BFS here but it went in infinite loop. So, I came up with DFS approach.
Known issues: None
Leet Code submitted.
*/

import java.util.Arrays;

public class FindIslands {
    public static int numIslands(char[][] grid) {

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int islands = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfsHelper(i,j,grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void dfsHelper(int i, int j, char[][] grid){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length ) {
            if(grid[i][j] == '1') {

                grid[i][j]='0';
                dfsHelper(i+1,j,grid);
                dfsHelper(i-1,j,grid);
                dfsHelper(i,j+1,grid);
                dfsHelper(i,j-1,grid);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(numIslands(new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
    }
}

