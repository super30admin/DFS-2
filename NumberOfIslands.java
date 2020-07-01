class Solution {
// Time Complexity : O(m*n)  2mn: worst cases all are 1's, then for bfs of 1 island m*n, for traversing                                   others which are 0's m*m
// Space Complexity : O(m*n)  when all are 1's
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use dfs method through recursion and traverse till all the connected 1's are covered.
 */
    
    int[][] dirs;
    int m; int n;
    
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        
        int count =0;
        dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
        m = grid.length; n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]== '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]=='0') return;
        
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = i+dir[0];
            int c = j+dir[1];
            dfs(grid,r,c);
        }
            
    }
}



class Solution {
// Time Complexity : O(m*n)  2mn: worst cases all are 1's, then for bfs of 1 island m*n, for traversing                                   others which are 0's m*m
// Space Complexity : O(Min(m,n))  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use bfs method through queue and traverse till all the connected 1's are covered.
 */
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int count =0;
        int[][] dirs = {{-1,0},{0,-1},{1,0},{0,1}};
        int m = grid.length; int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]== '1'){
                    count++;
                    grid[i][j] = '0';
                    q.add(new int[] {i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1'){
                                grid[r][c]='0';
                                q.add(new int[] {r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}