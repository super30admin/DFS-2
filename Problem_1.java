// Time Complexity : O(n. m), n = no. of rows, m = no. of columns
// Space Complexity : O(n. m)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid == null || grid.length == 0)
            return 0;
        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    queue.add(new int[]{i,j});
                    grid[i][j] = '0';
                    result += 1; 
                }
         
                while(!queue.isEmpty()){
                    int len =  queue.size();
                    for(int k = 0; k < len; k++){
                        int[] node = queue.poll();
      
                        for(int[]dir : dirs){
                            int r = node[0] - dir[0];
                            int c = node[1] - dir[1];
                            if(r < n && r >= 0 && c < m && c >=0 && grid[r][c] == '1'){
                                queue.add(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
