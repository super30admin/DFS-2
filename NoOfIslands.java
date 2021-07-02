
//Time complexity : O(M×N)
//Space complexity : O(min(M, N))


class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
    int count = 0;
    int n = grid.length;
    if (n == 0) return 0;
    int m = grid[0].length;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++)
            if (grid[i][j] == '1') {
                DFSMarking(grid, i, j, n, m);
                ++count;
            }
    }    
    return count;
}

private void DFSMarking(char[][] grid, int i, int j, int n, int m) {
   
    if(i < 0 || i > n -1 || j < 0 || j > m-1 || grid[i][j] == '0')return;
    
    grid[i][j] = '0';
    
    for(int[] d: dir){
        DFSMarking(grid,i+d[0],j+d[1],n,m);
    }
    
}
}
