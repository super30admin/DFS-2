// Time Complexity : O(m x n)
// Space Complexity : O(m x n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.*;
public class NumberOfIsland {
    static  int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}};

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    Queue<Integer> que = new LinkedList<>();
                    grid[i][j] = '0';
                    que.add(i);
                    que.add(j);
                    while(!que.isEmpty()) {
                        int r = que.poll();
                        int c = que.poll();
                        for(int[] d : dir) {
                            int cr = d[0] + r;
                            int cc = d[1] + c;
                            if(cr >= 0 && cr < m && cc >= 0 && cc < n && grid[cr][cc] == '1') {
                                grid[cr][cc] = '0';
                                que.add(cr);
                                que.add(cc);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println("The number of islands is: "+ numIslands(grid));
    }
}
