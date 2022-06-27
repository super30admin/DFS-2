//Time Complexity=O(MN)
//Space Complexity=O(MN)
public class NumberOfIslandsDFS {
    int[][] dir={{-1,0},{1,0},{0,1},{0,-1}};
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;

        int count=0;
        m=grid.length;n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,int i, int j){
        //base
        if(i<0 || j<0 || i==m || j==n || grid[i][j]=='0') return;
        //logic
        grid[i][j]='0';
        for(int[] dis: dir){
            int nr=i+dis[0];
            int nc=j+dis[1];
            dfs(grid,nr,nc);
        }
    }
}
