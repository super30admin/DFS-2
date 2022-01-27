// Time Complexity : O(mm) where m is row and n is column length of input grid
// Space Complexity : O(min(m, n)) where m is row and n is column length of input grid
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class NumberOfIsland{

}
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0, row = grid.length, col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        //this tracks the 4 directions
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        // for every character in the grid
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                //if island is found, do search for the neighboring cell to get the island
                if(grid[r][c] == '1'){
                    count++;
                    //bfs to find adjacent 1s to form island
                    q.offer(new int[]{r,c});
                    //make it water to mark visited
                    grid[r][c] = '0';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        //move in four directions
                        for(int[] dir: dirs){
                            int nR = curr[0] + dir[0];
                            int nC = curr[1] + dir[1];
                            if(nR < 0 || nR >= row || nC < 0 || nC >= col || grid[nR][nC] != '1'){
                                continue;
                            }
                            //make it visited
                            grid[nR][nC] = '0';
                            //add to next search
                            q.offer(new int[]{nR, nC});
                        }
                    }
                }
            }
        }
        return count;
    }
}