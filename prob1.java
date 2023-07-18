// Time Complexity : O(n*m)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : Yes


class Solution {
    int m,n;
    boolean[][] check;
    public int numIslands(char[][] grid) {
        int count=0;
        this.m=grid.length;
        this.n=grid[0].length;
        this.check=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( check[i][j]==false && grid[i][j] == '1' ){
                    group(grid,i,j);
                    count++;
                }
            }
        }
       return count; 
    }
    public void group( char[][] grid, int i,int j){
        
        if(i<0||i>m-1||j<0||j>n-1||check[i][j]==true||grid[i][j]=='0')
            return;

        check[i][j]=true;
        group(grid,i,j+1);
        group(grid,i+1,j);
        group(grid,i,j-1);
        group(grid,i-1,j);
    }
}