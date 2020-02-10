//DFS 
//Time Complexity : O(m*n) m- number of rows, n- number of columns - as in the worst case if all cells are 1- we visit everything once
        //Also since we mark 0 to not visit it again.
 
//Space Complexity :  O(1) , recursive space - worst case O(m*n)

class Solution {
    int m=0,n =0;
    int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        
        if(grid == null || m==0) return 0;
        int count =0;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               
                if(grid[i][j] == '1')
                {
                
                    count++;
                    helper(grid,i,j);
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid,int i,int j){
        //Base
        if(i < 0 || i>= m || j < 0 || j >= n || grid[i][j] == '0') return;
        
        //Logic
        grid[i][j] = '0';
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid,r,c);
        }
    }
}




//BFS
//Time Complexity : O(m * n) - where m is the number of rows, n is the number of columns
//Space Complexity : O(min(m,n)) 
class Solution {
    int m=0,n =0;
    int dirs[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public int numIslands(char[][] grid) {
        m = grid.length;
        
        if(grid == null || m==0) return 0;
        int count =0;
        n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1')
                {
                    q.add(new int[]{i,j});
                    grid[i][j] = 0;
                    count++;
                    while(!q.isEmpty()){
                        int[] current = q.poll();
                        for(int[] dir : dirs){
                            int r = dir[0]+current[0], c = dir[1]+current[1];
                            if(r>=0 && r < m && c >=0 && c < n && grid[r][c] == '1')
                            {
                                q.add(new int[]{r,c});
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
 
}