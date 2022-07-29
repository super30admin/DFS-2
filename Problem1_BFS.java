//Time Complexity: O(m*n), where m is the no. of rows and n is the no. of columns
//Space Complexity: O(minimum(m,n); Maximum Queue Size
//Code run successfully on LeetCode.

public class Problem1_BFS {

    public int numIslands(char[][] grid) {
        
        if(grid == null|| grid.length == 0)
            return -1;
        
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][] {{-1,0},{0,-1},{1,0},{0,1}};
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i =0; i <m; i++){
            for(int j =0; j<n;  j++){
                
                if(grid[i][j] == '1'){
                    
                    grid[i][j] = '0';
                    result++;
                    
                    q.add(new int[] {i,j});
                    
                    while(!q.isEmpty()){
                        
                        int[] curr = q.poll();
                        
                        for(int[] dir : dirs){
                            
                            int nr = curr[0] + dir[0];
                            int nc = curr[1] + dir[1];
                            
                            if(nr >=0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == '1'){
                                
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr,nc});
                            }
                        } 
                    }
                }
            }
        }
        return result;
    }
}
