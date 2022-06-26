// Time Complexity : O(nm)+O(nm)===O(mn)
// Space Complexity : min of m and n
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//bfs 
class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
         //null
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        Queue<Integer> rq = new LinkedList<>(); //for row
        Queue<Integer> cq = new LinkedList<>(); //for colomn
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    rq.add(i); cq.add(j);
                    grid[i][j] = '0';
                    while(!rq.isEmpty()){
                        int cr = rq.poll();
                        int cc = cq.poll();
                        for(int [] dir: dirs){
                            int nr = cr + dir[0];
                            int nc = cc + dir[1];
                            //bound check
                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                                rq.add(nr); cq.add(nc);
                                grid[nr][nc] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
}

/*
//dfs 
class Solution {
    int [][] dirs;
    public int numIslands(char[][] grid) {
         //null
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        dirs = new int [][] {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, m , n);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid,r,c,m,n);
        }
    }
    
}
*/