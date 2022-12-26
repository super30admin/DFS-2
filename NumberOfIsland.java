//BFS solution:
// Time Complexity : O(mn) // we only travel one element atmost once.
// Space Complexity : O(min(m,n)) // beacuse we are getting the first 1 we will get the next values in the queue which are diagnoal to it.

/*
 * here get the first value which is 1 and add it to queue and change it to
 * 0.go in all four directions and change all 1's to 0s. add the new row and
 * column to the queue and return count of islands.
 */
class NumberOfIsland{
    int count;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        Queue<int []> q = new LinkedList<>();
        int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    q.add(new int[] {i, j});
                    count++;
                    grid[i][j] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir: dirs){
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

//DFS Solution
// Time Complexity : O(mn)
// Space Complexity : O(mn) //recursion stack will store all the elements in worst case

/*
 * find the first 1 and call the dfs function on that and change all 1's to 0's.
 * then go in all four direction and call the function again. 
 */
class Solution {
    int count;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        dirs = new int [][] {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    dfs(grid ,i, j, m , n);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n){
        //base
        
        //logic
        for(int[] dir: dirs){
            int nr = i + dir[0];
            int nc = j + dir[1];
            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                grid[nr][nc] = '0';
                dfs(grid, nr, nc, m, n);
            }
        }
    }
}