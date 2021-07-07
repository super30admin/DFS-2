# Time complexity:O(m*n)
# Space complexity: 0(m*n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No



class Solution {
    int[] dx = new int[] {-1,0,1,0};
    int[] dy = new int[]{0,1,0,-1};

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)  return 0;

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfsVisit(grid,m,n,i,j);
                }

            }
            }
        return count;
        }

        private void dfsVisit(char[][] grid, int m, int n, int row, int col){
            grid[row][col] = '2';

            for(int i = 0; i < 4; i++){
                int x = row + dx[i];
                int y = col + dy[i];

                if(isValid(grid, m, n, x, y) && grid[x][y] == '1'){
                dfsVisit(grid, m, n, x, y);
            }

            }
        }

        private boolean isValid(char [][] grid, int m, int n, int x, int y){
            return x >= 0 && x < m && y >= 0 && y < n;
        }

}