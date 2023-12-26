// Time Complexity : O(m*n) //2 times O(m*n) - for loop, queue
// Space Complexity :O(min(m,n)+2) diagonal length of matrix + 2 // queue space for each iteration
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Use BFS approach - Loop through every node in matrix, if 1, add to queue, find all the adjacent 1s and change to 0s.
// Use queue to work on adj nodes. Increment count every time queue is empty

import java.util.Queue;
import java.util.LinkedList;

class NumberOfIslands {
    //Using BFS
    public int numIslands(char[][] grid) {
        int[][] dir = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};

        int m = grid.length; //no. of rows
        int n = grid[0].length; //no. of cols
        int count = 0;
        Queue<int[]> qu = new LinkedList();
        for(int i=0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    qu.add(new int[]{i,j});
                }
                while(!qu.isEmpty()){
                    int[] curr = qu.poll();
                    for(int k=0;k<dir.length;k++){
                        int p = dir[k][0] + curr[0];
                        int q = dir[k][1] + curr[1];

                        if(p<0 || q< 0|| p>m-1 || q> n-1) continue;
                        if(grid[p][q] == '1') {
                            qu.add(new int[]{p,q});
                            grid[p][q] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();
        char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int c = n.numIslands(grid);
        System.out.println(c);
    }
}