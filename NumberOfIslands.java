// 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/description/


// Solution 1 => BFS

/**
 * Time Complexity: O(m * n) since we iterate entire matrix
 * Space Complexity: O(min(m, n)) since in worst case i.e if we have all 1's we wont be having more than min(m,n) elements as we consider adjacent elements
 */

class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int dirs[][] = new int[][] { {1,0}, {-1,0}, {0,1}, {0,-1} };

        Queue<int []> q = new LinkedList<>();

        int count = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                // start fresh bfs from each 1
                if(grid[i][j] == '1'){

                    count++; // since this bfs would process all adjacent 1's, island count should be increased

                    q.add(new int[] {i, j});

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] dir: dirs){
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];

                            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                grid[r][c] = '0'; // make it 0, so we dont start new bfs from this 1 as its already a part of island
                                q.add(new int[] { r, c});
                            }
                        }
                    }

                }
            }
        }

        return count;
    }
}


// Solution 2 => DFS

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */

class Solution {
        int m;
        int n;
        int dirs[][];

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        dirs = new int[][] { {1,0}, {-1,0}, {0,1}, {0,-1} };

        int count = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){

                // start fresh bfs form each 1
                if(grid[i][j] == '1'){
                    count++;

                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid){

        // logic

        for(int[] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];

            // check bounds and if adjacent element is 1 move forward with dfs
            if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                grid[r][c] = '0';
                dfs(r, c, grid); 
            }
        }
    }
}