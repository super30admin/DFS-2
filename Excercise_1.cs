// Time complexity Of solution is 
// O(n*M)  N : rows ,M : column 
//

public class Solution {
    public int NumIslands(char[][] grid) {

     int m = grid.Length;
     int n = grid[0].Length;
      int[][] dirs = new int[][]{
                    new int[] { 0, 1 },
                    new int[] { 0, -1 },
                    new int[] { 1, 0 },
                    new int[] { -1, 0 }
                }; 

            int count = 0;
     for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j] == '1'){
                    dfs(grid,dirs,i,j,m,n);
                    count++;
            }
        }
     }

    return count;
    }


    public void dfs(char[][] grid,int[][] dirs,int i,int j,int m , int n){
       if(grid[i][j] != '1') return;

        grid[i][j] = '2';

        foreach(int [] dir in dirs){
            int nr = i +dir[0];
            int nc = j +dir[1];

            if(nr>=0 && nc>=0 && nr<m && nc<n){
                dfs(grid,dirs,nr,nc,m,n);
            }
        }
    }
}
