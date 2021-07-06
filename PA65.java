//Leetcode :200. Number of Islands
//DFS solution
//Time Complexty: O(m*n) 
//Space Complexity: O(min(m,n)) , where m and n are number of rows and column of grid
class Solution {
    int res;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        res=0;
        dirs= new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        int row = grid.length;
        int col = grid[0].length;      
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        for(int[] dir : dirs){
            dfs(grid, i+dir[0],j+dir[1]);
        }
        return;
    } 
}

================================================================================

//Leetcode :200. Number of Islands
//BFS solution
//Time Complexty: O(m*n) 
//Space Complexity: O(min(m,n)) , where m and n are number of rows and column of grid
class Solution {
    int res;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        res=0;
        Queue<int[]> q= new LinkedList<>();  
        dirs= new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
        int row = grid.length;
        int col = grid[0].length; 
        int x;
        int y;
        int[] ar;
        for(int i=0; i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    res++;
                    grid[i][j]='0';
                    q.add(new int[]{i,j});           
                while(!q.isEmpty()){
                     ar = q.poll();
                    for(int[] dir : dirs){
                        x=dir[0]+ar[0];
                        y= ar[1]+dir[1];
                        if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]=='1'){
                                grid[x][y]='0';
                                q.add(new int[] {x,y});
                            }
                    }
                    
                }
             }
            }
        }
        return res;
    }
   
}
------------------------------------------------------