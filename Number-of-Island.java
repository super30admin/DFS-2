## Problem1 (https://leetcode.com/problems/number-of-islands/)
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Approach : This question can be done with both BFS and DFS.
// BFS approach:
// In this we want to give no of islands so we will run a loop and find a 1 and then we will add it in a queue and we will do a traversal and search if there is 1 at up,down,left, right if so we will add it in a queue.
// We will carry out BFS traversal for all islands.
// Also we don't need to keep track of levels so we don't need a size variable. For every island we will do a seperate dfs so we can keep a variable and return that
// Time Complexity : O(m*n) -> as we are visiting every node
// Space Complexity : O(m+n) -> the queue will hold maximum m+n elements in worst case 
// Space Complexity    : O(max(m,n))    
 class Solution {
    public int numIslands(char[][] grid) {
        //Base Condition
        if(grid==null || grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        //Dirs array to iterate in 4 directions
        int[][] dirs={{-1,0},{0,-1},{0,1},{1,0}};
        int island=0;
        //for loop for finding 1 and adding it in a queue
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    Queue<int[]> q=new LinkedList<>();
                    island++;
                    q.add(new int[]{i,j});
                    grid[i][j]='2';
                
                while(!q.isEmpty()){
                    int[] curr=q.poll();
                    for(int[] dir:dirs){
                        int nr=curr[0]+dir[0];
                        int nc=curr[1]+dir[1];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1'){
                            q.add(new int[]{nr,nc});
                            grid[nr][nc]='2';
                        }
                    }
                }
               
                }
                 
            }
            
        }
        return island;
    }
}

//DFS solution:
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
class Solution {
    int[][] dirs;
    int m;
    int n;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        m=grid.length;
        n=grid[0].length;
        dirs=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        int level=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    level++;
                    dfs(grid,i,j);
                }
                 
            }
            
        }  
        return level;  
    }
    private void dfs(char[][] grid,int i,int j){
        //base
        if(i<0 || i==m || j<0 || j==n || grid[i][j]!='1'){
            return;
        }
        //processing
        grid[i][j]='2';
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            dfs(grid,nr,nc);
        }

    }

}