class Solution {
    int [][]dirs;
    int m,n;
    public int numIslands(char[][] grid) {
        dirs=new int [][]{{0,1},{0,-1},{1,0},{-1,0}};
        m=grid.length;
        n=grid[0].length;
        // System.out.println("m = "+m +"n = "+n );
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // System.out.println("i = "+i +"j = "+j );
                if(grid[i][j]=='1'){
                    count=count+1;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i==m||j==n||i<0||j<0||grid[i][j]=='0') return;

        grid[i][j]='0';
        for(int []dir:dirs){
            int r=i+dir[0];
            int c=j+dir[1];
            dfs(grid,r,c);
        }

    }

}