//200. Number of Islands - https://leetcode.com/problems/number-of-islands/description/
//Time Complexity: O(2(m*n)) to scan entire matrix * bfs call at every island ~ O(m*n)
//Space Complexity: O(min(m,n) diagonal of the matrix ~ O(n) -> queue space

//BFS
class Solution {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,-1},{0,1}};
        int countIslands = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    //for island 1
                    countIslands++;
                    q.add(new int[]{i,j});

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];

                            if(r>=0 && c>=0 && r<m && c<n && grid[r][c] == '1'){
                                //marking visited
                                grid[r][c]='0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                } //go through each island and find connected components to it
            }
        }
        return countIslands;
    }
}

//Time Complexity: O(2(m*n)) to scan entire matrix * bfs call at every island ~ O(m*n)
//Space Complexity: O(m*n) -> worst case all nodes are 1's
//DFS
class Solution {
    int[][] dirs;
    int m, n;
    public int numIslands(char[][] grid) {
        this.dirs = new int[][]{{-1,0}, {1,0}, {0,-1},{0,1}};
        int countIslands = 0;
        this.m = grid.length;
        this.n = grid[0].length;

        for(int i=0; i<m ;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    countIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return countIslands;
    }

    private void dfs(char[][] grid, int i, int j){
        //base case
        if(i<0 || j<0 || i==m || j==n || grid[i][j] != '1'){
            return;
        }
        //logic
        //mark the node visited
        grid[i][j]='0';
        //go through each direction
        for(int[] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;

            dfs(grid, r, c);
        }

    }
}