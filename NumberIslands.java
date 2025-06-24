// Time Complexity : O(mn)
// Space Complexity : min O(m,n)

import java.util.Queue;
import java.util.LinkedList;

public class NumberIslands {
    int [][] grid = {{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};
    int [][] dirns = {{0,1},{1,0},{0,-1},{-1,0}};
    int numberOfIslands = 0;

    public int calculateNumberOfIslands() {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numberOfIslands++;
                    int [] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    bfs(arr);
                }
            }
        }
        return numberOfIslands;
    }

    public void bfs(int[] arr) {
        Queue<int []> q = new LinkedList<int []>();
        grid[arr[0]][arr[1]] = 0;
        q.add(arr);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int [] coords = q.poll();
                for (int l = 0; l < dirns.length; l++) {
                    int new_x = coords[0] + dirns[l][0];
                    int new_y = coords[1] + dirns[l][1];
                    if (new_x >= 0 && new_y >= 0 && new_x < grid.length && new_y < grid[0].length && grid[new_x][new_y] == 1) {
                        grid[new_x][new_y] = 0;
                        int [] arr1 = new int[2];
                        arr1[0] = new_x;
                        arr1[1] = new_y;
                        q.add(arr1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberIslands ni = new NumberIslands();
        System.out.println(ni.calculateNumberOfIslands());
    }
}
