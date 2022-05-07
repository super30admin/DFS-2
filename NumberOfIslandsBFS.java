// Time Complexity :O(m*n)
// Space Complexity :O(min(m,n))
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFS {
    public int numIslands(char[][] grid) {
        //bfs
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1,0},{0,-1},{0,1},{1,0}};

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){

                    count++;
                    grid[i][j] = '0';
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){

                        int size = queue.size();
                        for(int k = 0; k < size; k++){
                            int[] startingPoint = queue.poll();

                            for(int[] dir: dirs){

                                int newRow = startingPoint[0]+dir[0];
                                int newCol = startingPoint[1]+dir[1];

                                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol <n && grid[newRow][newCol] == '1'){
                                    grid[newRow][newCol] = '0';
                                    queue.add(new int[]{newRow,newCol});
                                }

                            }
                        }
                    }

                }
            }
        }

        return count;
    }
}
