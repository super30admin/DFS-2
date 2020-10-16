// Time Complexity : O(mn), would need to visit all nodes to check if '1' or '0'
// Space Complexity : O(mn) in worst case if all nodes are connected
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Did with the bfs approach first, got a TLE
//had a minor bug in my code, then also did it with the dfs approach

// Your code here along with comments explaining your approach
// process the 2d grid, inorder to track seen vs unseen 1's we convert 1's to 2's (unvisited)
// then proceed with calling bfs/dfs on the first unseen node
// then convert all the unseen 1's, represented as 2's to '1's
// num islands is equal to the num times we have to initiate bfs/ dfs
class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m,n;
    
    private void bfs(int r, int c, char[][] grid){
        Queue<int[]> queue = new LinkedList<int[]>();
        grid[r][c] = '1';
        queue.offer(new int[]{r, c});
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] node = queue.poll();
                
                for(int[] dir : dirs){
                    int n_r = dir[0]+node[0];
                    int n_c = dir[1]+node[1];
                    if(n_r>=0 && n_r<m && n_c>=0 && n_c<n && grid[n_r][n_c]=='2'){
                        grid[n_r][n_c] = '1';
                        queue.offer(new int[]{n_r, n_c});
                    }
                }                
            }
        }
    }
    
    private void dfs(int r, int c, char[][] grid){
        grid[r][c] = '1';
        
        if(r-1>=0 && grid[r-1][c]=='2') dfs(r-1, c, grid);
        if(r+1<m && grid[r+1][c]=='2') dfs(r+1, c, grid);
        if(c-1>=0 && grid[r][c-1]=='2') dfs(r, c-1, grid);
        if(c+1<n && grid[r][c+1]=='2') dfs(r, c+1, grid);
    }
    
    public int numIslands(char[][] grid) {
        this.m = grid.length; 
        this.n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){
                    grid[i][j] = '2';
                }
            }
        }
        
        
        int numIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='2'){
                    dfs(i, j, grid);
                    //bfs(i, j, grid);
                    numIslands++;
                }
            }
        }
        
        return numIslands;
    }
}