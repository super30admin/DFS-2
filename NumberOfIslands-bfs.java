//Time complexity: O(M * N) or exact O(2MN)
//Space complexity: O(min(M,N))
class Solution {
    public int numIslands(char[][] grid) {

        //number of rows
        int m = grid.length;
        //number of columns
        int n = grid[0].length;
        int num_islands = 0;
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                //if we find 1 we will increment the count by 1 
                if(grid[i][j] == '1') {
                    num_islands++;
                    //mark it as visited and add it to the queue
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    //We will check the nodes on 4 direction
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        for(int[] dir: dirs) {
                            int r = curr[0] + dir[0];
                            int c = curr[1] + dir[1];
                            //check the boundary condition
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                //mark it as visited and add it to the queue
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return num_islands;
    }
}