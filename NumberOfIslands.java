//https://leetcode.com/problems/number-of-islands

class Solution {
    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int islands =0;
     int m,n;
    int ones;
    public int numIslands(char[][] grid) {
         m = grid.length;
         n = grid[0].length;
        ones=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    q.add(i); q.add(j);
                    ones++;
                }
            }
        }
        
        while(ones !=0){
            //System.out.println("while");System.out.println("ones:"+ones);
            int cr = q.poll();
            int cc = q.poll();
            if(grid[cr][cc] =='1'){
                grid[cr][cc] ='0';
                ones--;
                //System.out.println(cr+""+cc);
                
                islands++;
                dfs(grid,cr,cc);
            }
            if(ones==1){
                islands++;
                break;
            }
        }
        //System.out.println("ones:"+ones);
        //System.out.println(Arrays.deepToString(grid));
        return islands;
    }
    private void dfs(char[][] grid, int cr, int cc){
        //System.out.println("dfs");
        for( int[] dir : dirs){
            int nr = cr + dir[0];
            int nc = cc + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc]== '1'){
                grid[nr][nc] = '0';
                ones--;
                dfs(grid,nr,nc);
            }
        }
    }
}
