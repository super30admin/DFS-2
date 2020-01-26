// Time complexity 0(m*n) no of rows and columns
// space complexity 0(n) 
// code successfully executed in leetcode.
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0) return 0;
        int n = grid[0].length;
        int count =0;
        int [][] dirs ={{0,1},{0,-1},{1,0},{-1,0}};
        //Queue<Integer []> q1 = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int []> q1 = new LinkedList<>();
                    q1.add(new int []{i,j});
                    grid[i][j] ='0';
                    while(!q1.isEmpty()){
                        int curr [] = q1.poll();
                        for(int [] dir: dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                 if(r >=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                     q1.add(new int [] {r,c});
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