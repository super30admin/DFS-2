//Time Complexity: O(m * n).
//Space Complexity: O(m*n).

//This problem can also be solved using BFS snd DFS. The space complexity in BFS is nothing but the number of elements which are present in Queue at any given point. 


class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0,-1}}; //UDRL
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int total = 0;

        for(int i =0; i < m; i++){
            for(int j = 0; j < n;j++){
                if(grid[i][j] == '1'){
                    DFS(i, j, grid);
                    total ++;
                }
            }
        }
        return total;
    }
    
    public void DFS(int row, int col, char[][] grid){
        //base condition: 
        if(row < 0 || row >= m || col >= n || col < 0 || grid[row][col] != '1') return;
        grid[row][col] ='0';
        for(int[] dir:dirs){
            int newrow = row + dir[0];
            int newcol = col + dir[1];
            DFS(newrow, newcol, grid);
        }
    }
}