/**
LeetCode Submitted : YES
Space Complexity : O(M*N)
Time Complexity: O(M*N)

The idea is to call DFS when node = land i.e. 1 and recursively iterate the grid till we reach an island or exhaust all options of the matrix. Also,I have created a visited array to keep track of duplicate matrix so we dont update/traverse  the same node again and again.

**/

class Solution {
    int[][] visited;
    int m;
    int n;
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length < 1)
            return 0;
        
        m =  grid.length;
        n = grid[0].length;
        
        visited = new int[m][n];
        
        int start_x = -1;
        int start_y = -1;
        
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    start_x = i;
                    start_y = j;
                    break;
                }
                    
            }
        }
        
        if(start_x == -1 && start_y == -1)
            return 0;
        
        int count = 0;
        while(true){
            dfs(grid, start_x, start_y);
            count ++;
            //printVisited(visited);
            int[] node =  checkVisited(visited,grid);
            if(node[0] == -1 && node[1] == -1)
                return count;
            
            start_x = node[0];
            start_y = node[1];
        }
            
        
    }
    
    private void printVisited(int[][] visited){
        for(int i = 0; i< visited.length; i++){
            for(int j = 0; j< visited[0].length; j++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
            System.out.println("----------------");
        }
    }
    private int[] checkVisited(int[][] visited,char[][] grid){
        for(int i = 0; i< visited.length; i++){
            for(int j = 0; j< visited[0].length; j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    return (new int[]{i,j});
                }
            }
        }
        return (new int[]{-1,-1});
    }
    
    private void dfs(char[][] grid, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || visited[i][j] == 1)
            return;
        
        visited[i][j] =  1;
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(grid,row,col);
        }
        
        
    }
}
