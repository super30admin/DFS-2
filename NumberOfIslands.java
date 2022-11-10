package s30.DFS1.DFS2;

import java.util.LinkedList;
import java.util.Queue;

//BFS
// Time Complexity O(mn) traversing all the elements in worst case
// Space Complexity O(d) at most we will have min(m,n) elements in queue.
public class NumberOfIslands {

    private int[][] directions = {
            {1,0},
            {0,1},
            {-1,0},
            {0,-1}
    };

    private Queue<Pair> q;
    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n= grid[0].length;
        int res =0;
        q =  new LinkedList();


        for(int i = 0; i < m; i++){
            for(int j=0; j < n; j++){
                if(grid[i][j] =='1') {
                    q.add(new Pair(i,j));
                    bfs(grid, i,j);
                    res++;
                }

            }
        }

        return res;
    }

    private void bfs(char[][] grid, int i, int j){

        int m = grid.length;
        int n= grid[0].length;
        grid[i][j] = '0';

        while(!q.isEmpty()){

            Pair p = q.poll();


            for(int[] d : directions){
                int tempI = p.i + d[0];
                int tempJ = p.j + d[1];

                if(tempI >=0 && tempI < m && tempJ >=0 && tempJ < n && grid[tempI][tempJ] == '1'){
                    q.add(new Pair(tempI, tempJ));
                    grid[tempI][tempJ] = '0';
                }

            }
        }
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j){
            this.i =i;
            this.j= j;
        }
    }
    public static void main(String[] args) {

    }
}
