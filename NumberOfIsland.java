//BFS approach
// Time Complexity : O(2mn) = O(mn), in worst case we will be doing BFS only once and iterating over each element (m*n) marking it 0, then the outer for loop will iterate over whole matrix(m*n)
// Space Complexity : min(m,n),worst case:  all 1s. at any point queue will have at max min of (m,n) elements.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Do  a fresh BFS when a new 1 is encountered i.e starting of island.

class Solution {
    int m; int n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        this.dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n ;j++){
                if(grid[i][j]== '1'){
                    grid[i][j] = '0'; // to mark it visited
                    q.add(i);
                    q.add(j);
                
                    while(!q.isEmpty()){
                        int r = q.poll();
                        int c = q.poll();

                        for(int[] dir : dirs){
                            int nr = r + dir[0];
                            int nc = c + dir[1];

                            if(nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.add(nr);
                                q.add(nc);
                            }
                        }
                    }
                    count++;
                }
            }
        }

        return count;

    }
}


//DFS approach
// Time Complexity : O(2mn) = O(mn), in worst case we will be doing BFS only once and iterating over each element (m*n) marking it 0, then the outer for loop will iterate over whole matrix(m*n)
// Space Complexity : O(m*n), all 1s. Everything will be in the recursive stack.
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : start from first encountered island and keep marking visited nodes as zero.

class Solution {
    int m;
    int n;
    int[][] dirs;
    int count;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        this.dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        this.count = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
                
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int r, int c) {

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == '1') {
                grid[nr][nc] = '0'; // mark them visited.
                dfs(grid, nr, nc);
            }
        }
    }
}
