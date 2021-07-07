//DFS
//Time Complexity : O(m*n). In the worst case(all 1's), the dfs function is called O(m*n) times and the outer loop will execute O(m*n) times as there would be only 0's left. Hence 2O(m*n)~O(m*n)
//Time Coplexity : O(m*n)

class Solution {
    int row,col;
    int num_of_islands=0;
    public void dfs(char grid[][],int cr,int cc){
        if(cr<0 || cr>=row || cc<0 || cc>=col || grid[cr][cc]=='0'){
            return;
        }
        //mark visited
        grid[cr][cc] = '0';
        //direction array to find the four cornors
        int dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}};
        //apply dfs to surrounding nodes to check if there are 1's or 0's
         for(int dir[] : dirs){
                int r = cr + dir[0];
                int c = cc + dir[1];
                dfs(grid,r,c);
         }
    }
    public int numIslands(char[][] grid) {
        
         row = grid.length;
         col = grid[0].length;
        //iterate through the grid
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //if 1 is found start thr dfs
                if(grid[i][j]=='1'){
                    num_of_islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return num_of_islands;
    }
}
//BFS
//Time Complexity : O(m*n). In the worst case(all 1's). Hence O(m*n)
//Space Complexity : O(m*n)
class Solution {
    int row,col;
    int num_of_islands=0;
    
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>();
         row = grid.length;
         col = grid[0].length;
        //iterate through the grid
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //if 1 is found start thr dfs
                if(grid[i][j]=='1'){
                    num_of_islands++;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        //direction array to find the four cornors
                        int dirs[][] = {{0,-1},{1,0},{0,1},{-1,0}};
                        //apply dfs to surrounding nodes to check if there are 1's or 0's
                        for(int dir[] : dirs){
                            int r = cur[0] + dir[0];
                            int c = cur[1] + dir[1];
                            if(r>=0 && r<row && c>=0 && c<col && grid[r][c]=='1'){                  
                                 //mark visited
                                    grid[r][c] = '0';
                                    q.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        
        return num_of_islands;
    }
}