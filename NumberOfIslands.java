// Time Complexity O(m x n)
// Space Complexity O(m x n)
// Runs on LeetCode YES

class Solution {
    public int numIslands(char[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int result = 0;

        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[0].length; j++){

                if(grid[i][j] == '1'){

                    q.add(new int[]{i,j});
                    result++;

                    while(!q.isEmpty()){
                        int[] rc = q.poll();
                        for(int [] dir: dirs){
                            int row = rc[0] + dir[0];
                            int col = rc[1] + dir[1];

                            if(row < grid.length && col < grid[0].length && row >= 0 && col >=0 && grid[row][col] == '1'){
                                q.add(new int[]{row, col});
                                grid[row][col] = 0;
                            }
                        }
                    }

                }
            }
        }
        return result;
    }
}