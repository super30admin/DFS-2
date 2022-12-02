//Time complexity is O(M*N)
//Space compleity is O(M*N)
class Solution {
    int result =0;
    int[][] dirs = new int[][]{ new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
    public int numIslands(char[][] grid) {
        int result =0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visit[i][j]){
                    visit[i][j]=true;
                    result=result+1;
                    helper(grid, i, j, visit);
                }
            }
        }
        return result;
    }
    public void helper(char[][] grid, int i, int j, boolean[][] visit){
        int m = grid.length;
        int n = grid[0].length;
        for(int[] dir : dirs){
            int x = dir[0]+i;
            int y = dir[1]+j;
            if(x>=0 && x<m && y>=0 && y<n && !visit[x][y] && grid[x][y]=='1'){
                visit[x][y]=true;
                helper(grid, x, y, visit);
            }
        }
    }
}