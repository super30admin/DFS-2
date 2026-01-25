//way1
//BFS
//Travel every element
//If it is one, then check all connected 1's using bfs
//While placing in queue make 1 to 0 to avoid repetetions
//For every bfs, increment result by 1
//TC: O(m*n); Sc:O(m*n)
class Solution {
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result+=1;
                    bfs(grid,i,j);
                }
            }
        }
        return result;
        
    }

    private void bfs(char[][] grid,int r, int c){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{r,c});
        grid[r][c]='0';

        while(!(queue.isEmpty())){
            int[] curr=queue.poll();
            for(int[] d:dir){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];

                if((nr>=0 && nr<grid.length) && (nc>=0 && nc<grid[0].length) && grid[nr][nc]=='1'){
                    queue.add(new int[]{nr,nc});
                    grid[nr][nc]='0';
                }
            }
        }
    }
}


//way2
//DFS
//Travel every element
//If it is one, then check all connected 1's using dfs
//Make all connected 1's to 0's
//For every bfs, increment result by 1
//TC: O(m*n); Sc:O(m*n)
class Solution {
    int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int numIslands(char[][] grid) {
        int result=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result+=1;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
        
    }

    private void dfs(char[][] grid,int r, int c){
        //
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]=='0'){
            return;
        }

        grid[r][c]='0';


        //
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];

            dfs(grid,nr,nc);
        }

    }
}
