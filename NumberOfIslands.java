

// TC : O(mn)
// SC : O(mn)

package S30_Codes.DFS_2;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row, col;
    Pair(int i, int j){
        row = i;
        col = j;
    }
}

class NumberOfIslands {
    int[][] directions = {
        { 0,  1},
        { 0, -1},
        {-1,  0},
        { 1,  0}
    };

    private static final char LAND = '1', WATER = '0';

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;

        Queue<Pair> queue = new LinkedList();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == LAND){
                    queue.add(new Pair(i, j));
                    grid[i][j] = WATER;

                    while(!queue.isEmpty()){
                        Pair p = queue.poll();

                        for(int[] dir : directions){
                            int nextI = dir[0] + p.row;
                            int nextJ = dir[1] + p.col;

                            if(nextI>=0 && nextI<m && nextJ>=0 && nextJ<n && grid[nextI][nextJ] == LAND){
                                grid[nextI][nextJ] = WATER;
                                queue.add(new Pair(nextI, nextJ));
                            }
                        }
                    }

                    count++;
                }
            }
        }
        return count;
    }
}
