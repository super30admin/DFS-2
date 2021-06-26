// 200. Number of Islands

class Solution {
    int m;  int n;  
    public int numIslands(char[][] grid) {
        //corner cases
        
        if(grid == null || grid.length == 0) return 0;
        m = grid.length; n = grid[0].length;
        int count = 0;
        
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i ,j);
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j)
    {
        if( i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1')
            return;
            
        int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        for(int [] dir : dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
        
    }

  }


        
 /*
        // Solution using BFS 
        if(grid == null || grid.length == 0) return 0;
        int m = grid.length; int n = grid[0].length;
        int count = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int [][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == '1'){
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';
                    
                    while(!q.isEmpty()){
                        int cr = q.poll();
                        int cc = q.poll();
                        for(int [] dir : dirs){
                            int r = cr + dir[0];
                            int c = cc + dir[1];
                            
                            if(r >=0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                                q.add(r);
                                q.add(c);
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

*/

/*
Complexity Analysis

Time Complexity : O(m*n)
Space Complexity : O(min(m,n))
*/