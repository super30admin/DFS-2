/*
    L.C: 200. Number of Islands

    Approach: BFS

    Time Complexity: O(m * n)
    Space Complexity: O(m * n)

*/
class NumberOfIslands {
    public int numIslands(char[][] grid) {

        if(grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0;i<grid.length; i++) {
            for(int j=0;j<grid[0].length; j++){

                if(grid[i][j] == '1') {
                    bfs(grid, i,j, m, n);
                    count++;
                }
            }
        }

        return count;

    }

    private void bfs(char[][] grid, int i, int j, int m, int n) {

        int[][] direction = {
                {-1, 0}, //U
                {1,0}, //D
                {0, 1}, //R
                {0, -1}//L
        };


        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = '2';

        while(!q.isEmpty()) {

            int size = q.size();

            for(int k=0;k<size; k++){

                int[] a = q.poll();

                int row = a[0];
                int col = a[1];

                for(int[] dir: direction) {

                    int x = dir[0]+row;
                    int y = dir[1]+col;

                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y] == '1') {
                        q.add(new int[]{x,y});
                        grid[x][y] = '2';
                    }
                }
            }
        }
    }
}
