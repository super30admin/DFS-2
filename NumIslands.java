// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
    
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid[i].length; j++){
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    num++;
                }
            }
        }
        
        return num;
    }
    
    private void bfs(char[][] grid, int sr, int sc){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        grid[sr][sc] = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1}, {0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] current = q.poll();
                for(int[] dir : dirs){
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];
                    if(row >= 0 && row < grid.length && col >=0 && col < grid[row].length && grid[row][col] == '1'){
                        q.add(new int[]{row, col});
                        grid[row][col] = '0';
                    }
                }
            }
        }
    }
}