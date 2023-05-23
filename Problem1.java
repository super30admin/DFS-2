import java.util.*;
// Time: O(mn)
class Solution {
    public void dfs(char[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j< 0 || i>=m || j>=n || grid[i][j]!='1')
            return;
        grid[i][j] ='0';
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
    public int numIslands(char[][] grid) {

        int islands= 0 ;
        for(int i = 0 ; i< grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        // int[] visited = new int[10];
        // int count = 0;
        // int m = grid.length;
        // int n = grid[0].length;

        // Queue<Pair<Integer,Integer>> q = new LinkedList<>();
        // for(int x = 0 ; x < grid.length ; x++){
        //     for(int y = 0 ; y< grid[0].length ; y++){
        //         if(grid[x][y] == '1'){
        //             grid[x][y] = '0';
        //             count++;
        //             Pair<Integer, Integer> pair = new Pair(x,y);
                    
        //             q.add(pair);
        //             while(!q.isEmpty()){
        //                 Pair<Integer, Integer> p = q.remove();
        //                 int i = p.getKey();
        //                 int j = p.getValue();
        //                 if(j+1 <n && grid[i][j+1] == '1'){
        //                     q.add(new Pair(i, j+1));
        //                     grid[i][j+1] = '0';
        //                 }
        //                 if(i+1 <m && grid[i+1][j] == '1'){
        //                     q.add(new Pair(i+1, j));
        //                     grid[i+1][j] = '0';
        //                 }
        //                 if(j-1 >=0 && grid[i][j-1] == '1'){
        //                     q.add(new Pair(i, j-1));
        //                     grid[i][j-1] = '0';
        //                 }
        //                 if(i-1 >=0 && grid[i-1][j] == '1'){
        //                     q.add(new Pair(i-1, j));
        //                     grid[i-1][j] = '0';
        //                 }
        //             }
                                        
        //         }
        //     }
        // }
        // return count;



        //DFS
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0 ; i<m ; i++){
            for (int j = 0 ; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i, int j){
        int r =grid.length;
        int c = grid[0].length; 
        if(i<0 || j< 0  || i>=r || j >=c || grid[i][j]=='0')
            return;

        grid[i][j] = '0'; 
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
    }

}