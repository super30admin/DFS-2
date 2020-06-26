// Time Complexity :O(2mn) m and n is the length and breadth of the grid
// Space Complexity : O(mn) m and n is the length and breadth of the grid
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int n = grid.length; int m = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int[] dir : dirs){
                            int r = curr[0]+dir[0];
                            int c = curr[1]+dir[1];
                            if(r<n && r>=0 && c<m && c>=0 && grid[r][c] == '1'){
                                grid[r][c] = '0';
                                q.add(new int[]{r,c});
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