/*
Time Complexity: O(n*m), n is the number of rows, and m is the number of columns
Space Complexity: O(n*m), n number of rows and m number of columns, size of the recursion stack
Code run on Leetcode: Yes
Any difficulties: no

Approach:
1. '1' denotes island, now we can make big islands by clubbing all the '1's in the vicinity, until we encounter a '0'
2. everytime we encounter '1' I would increment count of the islands
3. TrackIsland method would help me to track for '1' in the vicinity like up, down, left, right
4. To make sure I have visited the '1' earlier I am gonna replace that particular index by '#' (already visited)
 */
public class NumberOfIslands {
    public static int numOfIsland(char[][] grid){
        int count = 0;

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    trackIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void trackIsland(char[][] grid, int row, int col){
        // Edge condition
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]!= '1'){
            return;
        }

        // already visited
        grid[row][col] = '#';

        // down
        trackIsland(grid, row+1, col);
        // up
        trackIsland(grid, row-1, col);
        // right
        trackIsland(grid, row, col+1);
        // left
        trackIsland(grid, row, col-1);
    }

    public static void main(String[] args){
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println("Number of Islands: "+numOfIsland(grid));
    }
}
