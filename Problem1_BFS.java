/**
LeetCode Submitted : YES
Space Complexity : O(M*N)
Time Complexity: O(M*N)

The idea is to use BFS when node = land i.e. 1 to store in Queue and then call all the 4 possible directions till we enconter land i.e. node = 1. Before processing the node in the queue make the node = "0" to avoid processing the same node again and again. After that if queue is empty increment counter and move to the next node till we encounter all possible nodes in the matrix.
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
        int count = 0;
        
        for(int i = 0; i< m;i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == '1'){
                    //dfs(grid, i, j);
                    Queue<int[]> q = new LinkedList<>();
                    count ++;
                    q.add(new int[]{i,j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        for(int[] dir : dirs){
                            int row = temp[0] + dir[0];
                            int col = temp[1] + dir[1];
                            
                            if(row>=0  && row<m && col >= 0 &&  col<n && grid[row][col] == '1'){
                                q.add(new int[]{row,col});
                                grid[row][col] = 0;
                            }
                        }
                    }
                }
                    
            }
        }
        return count;
        
    }
    
    private void dfs(char[][] grid, int i , int j){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0' || grid[i][j] == 0)
            return;
        
        grid[i][j] =  0;
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(grid,row,col);
        }
        
        
    }
}
