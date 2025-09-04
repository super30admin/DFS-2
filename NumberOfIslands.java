// Time Complexity : O(m*n)
// Space Complexity : O(2*m*n) for BFS and O(min(m,n)) for DFS because maximum depth of recursion is min(m,n) (diagonal)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We start by searching for 1s and mark all the neighbouring 1s as 0, we count that neighbouring 1s as one island and increase the count

class Solution {

    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int result = 0;
        int m = grid.length; int n = grid[0].length;
        
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j,m,n);
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0') return;
        grid[i][j] = '0';
        for(int [] dir:dirs){
            dfs(grid,i+dir[0],j+dir[1],m,n);
        }
    }

    public int numIslandsBFS(char[][] grid) {
        int result = 0;
        int m = grid.length; int n = grid[0].length;
        
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    Queue<int[]> q = new LinkedList();
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int[] dir:dirs){
                            int nr = dir[0]+cur[0];
                            int nc = dir[1] + cur[1];

                            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                                q.add(new int[]{nr,nc});
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}