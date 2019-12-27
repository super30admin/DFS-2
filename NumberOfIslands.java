// Time Complexity : O(MXN)
// Space Complexity : O(MXN) as we use Queue in BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.LinkedList;
import java.util.Queue;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){ //Base cases
            return 0;
        }
        int m=grid.length, n=grid[0].length; //Finding the dimensions of the given grid
        int result=0; //initiating the final result variable. This will be the return value.

        /* BFS method used below */
        Queue<int[]> queue=new LinkedList<>();
        int[][] dirs={{-1,0}, {1,0}, {0,-1}, {0,1}}; //neighbors
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='1'){ //For all the unvisited nodes i.e. land
                    result++; //The new group of land is formed only is it's a brand new land node.
                    grid[i][j]='V'; //Visited
                    queue.add(new int[]{i,j}); //Added in the queue.
                }

                /* Default BFS method */
                while(!queue.isEmpty()){
                    int[] currentNode = queue.poll();
                    for(int[] dir: dirs){
                        int newRow = currentNode[0]+dir[0];
                        int newColumn = currentNode[1]+dir[1];
                        if(newRow<=m-1 && newRow>=0 && newColumn<=n-1 && newColumn>=0 && grid[newRow][newColumn]=='1'){ //Edge cases
                            grid[newRow][newColumn]='V'; //Visited
                            queue.add(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String... args){
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
