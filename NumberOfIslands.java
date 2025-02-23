// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Depth First Search:-

class Solution {
    public int numIslands(char[][] grid) {
        
        //we will start from the land and perform BFS until all adjacent lands are covered
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int island = 0;

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1') {

                    dfs(grid, dirs, i, j);
                    island++;
                }
            }
        }

        return island;
    }

    public void dfs(char[][] grid, int[][] dirs, int r, int c) {

        if(r < 0 || r >= grid.length || c < 0 || c>= grid[0].length || grid[r][c] != '1')
            return;
        
        grid[r][c] = '0';

        for(int[] d: dirs) {

            int nr = r + d[0];
            int nc = c + d[1];

            dfs(grid, dirs, nr, nc);
        }
    }
}

/*
//Breadth first Search:-

class Solution {
    public int numIslands(char[][] grid) {

        //we will perform Breadth First Search on the grid, whenever we see a land we call BFS function
        int m = grid.length;
        int n = grid[0].length;

        //we will check are the 4 directions
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int numIsland = 0;

        //Iterate over the grid matrix
        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1') {

                    numIsland++;

                    //we will add lands to q
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()) {

                        int[] curr = q.poll();
                        int r = curr[0];
                        int c = curr[1];

                        //since we do not care about the levels or distinction, we dont take size
                        for(int[] d: dirs) {

                            int nr = r + d[0];
                            int nc = c + d[1];

                            //if we find a land we add it to q and mark as visited
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {

                                q.add(new int[]{nr, nc});
                                grid[nr][nc] = '0';
                            }
                        }
                        
                    }
                }
            }
        }

        return numIsland;
    }
}

//Time complexity:- {Worst case:- all cells are 1}  :- O(m * n) + O(m * n) = 2(m * n) = O(m * n)
/* Space complexity:- For worst case :- 
If all the cells are 1. Then at a point all diagonal elements will be in queue. Hence diagonal = min(m, n) = O(min(m, n)) */
