// Time Complexity : O(M * N)
// Space Complexity : O(min between M and N) for BFS and O(M * N) in DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We can use BFS/DFS approach. so no of islands will be no of times we will run BFS/DFS.
 * In each BFS iteration, we check all neibours of our current cell and if we hit '1', we changed it to '$' to mark it as visited
 * then we add it to queue to check its neibours.
 * In each DFS recursive call, if we hit cell with '1' we mark it as visited by putting '$' in it. 
 * Check its neibours and if we get '1' we run DFS on them
*/


class Solution {
    int row;
    int col;
    int ans;
    int[][] dir;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        row = grid.length;
        col = grid[0].length;
        ans = 0;
        
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                    ans++;
                   // dfs(grid, r, c);
                    bfs(grid, r, c);
                }
            }
        }
        
        return ans;
    }
    
    private void bfs(char[][] grid, int r, int c){
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r, c});
        grid[r][c] = '$';
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] d : dir){
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
            
                if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                    if(grid[nr][nc] == '1'){
                        q.add(new int[]{nr, nc});
                        grid[nr][nc] = '$';
                    }
                }
            }
            
        }
    }
    
    private void dfs(char[][] grid, int r, int c){
        //base case
        if(grid[r][c] == '$' || grid[r][c] == '0')return;
        //logic
        grid[r][c] = '$';
        
        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];
            
            if(nr >= 0 && nr < row && nc >= 0 && nc < col){
                dfs(grid, nr, nc);
            }
        }
    }
}