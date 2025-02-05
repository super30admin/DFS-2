class Solution {
    //Time Complexity : O(m*n)
    //Space Complexity : O(min(m,n))
    public int numIslands(char[][] grid) {

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        //iterate through the rows
        for (int i =0 ; i< n; i++){
        for (int j =0 ; j< m; j++){
            if (grid[i][j] == '1'){
                count++;
        Queue<int[]> q = new LinkedList<>();
                q.offer (new int[]{i,j});
                while (!q.isEmpty()){
                    int[] pt = q.poll();
                    for (int[] dir : dirs){
                        int nr = pt[0] + dir[0];
                        int nc = pt[1] + dir[1];
        if (nr >= 0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == '1'){
                q.offer (new int[]{nr,nc});
                grid[nr][nc] ='2';
        }
                    }
                }
            }
        }
        }
        return count;
    }
}