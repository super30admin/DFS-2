//TC: O(M*N) visit all nodes in worst case
//SC: O(M*N) 

//When you encounter '1', insert the row and column to queue. 
//Do BFS by updating visited nodes. Onces all the nodes, connected to one island are visited, return count.
//BFS is done for all connected 1s to get total number of islands.

import java.util.*;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        
    
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count += bfs(grid, i , j);
                }
            }
        }
        return count;
        
    }
        
    private static int bfs(char[][] matrix, int i , int j){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i,j});
        
        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int[] dir : directions){
                
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                
                if(r >=0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] == '1'){
                    matrix[r][c] = '0';
                    q.add(new int[]{r,c});
                }
            }
        }
    return 1;
    }

    public static void main(String[] args){
        char[][] image = {{'0','0','0'},{'1','0','0'},{'0','1','1'}};
        System.out.println(numIslands(image));
    }


}
