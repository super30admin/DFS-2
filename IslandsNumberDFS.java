public class IslandsNumberDFS {



        //DFS

        int[][] dirFour = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        public int m;
        public int n;

        public int numIslands(char[][] grid) {

            int nIslands = 0;

            m = grid.length; n = grid[0].length;

            if(grid == null || m == 0) return 0;

            // nested loops iterating over all elements in a grid
            for(int i = 0; i < m; i++) {

                for(int j = 0; j < n; j++) {

                    // new 1 = new isalnd starts
                    if(grid[i][j] == '1') {

                        // increase number of islands count by 1
                        nIslands++;

                        // run DFS at the newly found 1's position
                        dfsIsland(grid, i, j);
                    }
                }
            }
            // output the total number of islands
            return nIslands;
        }

        private void dfsIsland(char[][] grid, int i, int j) {

            //base
            // return if 0 is there at the position where DFS is called
            if(i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') return;

            //logic
            // make 1 as o when DFS is called
            grid[i][j] = '0';

            // check four directions of element where DFS is called
            for(int[] dir: dirFour) {

                int nr = dir[0] + i;
                int nc = dir[1] + j;

                // go for DFS at new neighbour
                dfsIsland(grid, nr, nc);
            }

        }


}

/*
Time Complexity = O(m*n)
nested for loops = m*n, single worst-case recursive DFS covering all grid positions (1) = m*n
worst case = 2(m*n) = O(m*n)

Space Complexity = O(m*n) - recursive stack
maximum of number of elements in recursive stack = single worst-case recursive DFS covering all grid positions (1) = m*n
*/

