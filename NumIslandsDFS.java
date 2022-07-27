//Time complexity :O(m*n)
//Space complexity:O(m*n)
// Using DFS:To Avoid extra space change it to -1 or 0 .But here given given to character array.DFS Abandon the parent and go to child down then after last row value it again comes to previous node and tak left and try to go up and ...If zero is there in matrix then no change .Suddenly I have  one then go for DFS  1+1 =2 times maintain a queue and check start node for 4 directions and add to queue and pop the element from queue and connected components.
//The sc m*n becoz entire Island could be 1's and all elements wen into recursive stack.grows ,1 col much better.diagonal only goes into Q.

class Solution {
    int total;
    int[][] dirs;
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        //DFS
        dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};//UDRL
        m = grid.length;
        n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    total++;
                    dfs(i,j,grid);
                }
            }
        }
        return total;
    }
    private void dfs(int r, int c,char[][] grid){
        //base
        if(r<0 || c<0 || r==m || c==n || grid[r][c] != '1')return;
        //logic
        grid[r][c] = '0';
        for(int[] dir:dirs){
            int nr = dir[0]+r;
            int nc = dir[1]+c;
            dfs(nr,nc,grid);
        }
    }
}