import java.util.*;

class NumberOfIsland {

    public int numIslands(char[][] grid) {
        //TC - O(MN) - Where M is number of Rows and N is number of columns
        //SC - O(MN) - If all elements are '1' it will have MN elements inside the queue.
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0; // There is no Island
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) { //MN
            for (int j = 0; j < n; j++) {
                noOfIslands += BFS(grid, i, j);
            }
        }
        return noOfIslands;
    }

    private int BFS(char[][] grid, int i, int j) {
        int noOfIslands = 0;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] { i, j });
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int valueFromGrid = grid[current[0]][current[1]];
            if (valueFromGrid == '1') {
                grid[current[0]][current[1]] = '0'; // Making it is visited.
                noOfIslands = 1;
                // Check for neighbours
                int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; //O(1)
                for (int[] dir : dirs) {
                    int row = dir[0] + current[0];
                    int column = dir[1] + current[1];
                    // Out of bound exception
                    if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length
                            && grid[row][column] == '1') {
                        queue.add(new int[] { row, column });
                    }
                }
            }
        }
        return noOfIslands;
    }


    public int numIslandsDFS(char[][] grid) { 
        //TC - O(MN) - Where M is number of Rows and N is number of columns
        //SC - O(MN) - If all elements are '1' it will have MN elements inside the recursion stack.
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0; // There is no Island
        int noOfIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) { //MN
            for (int j = 0; j < n; j++) {
                noOfIslands += DFS(grid, i, j);
            }
        }
        return noOfIslands;
    }

    private int DFS(char[][] grid, int i, int j) {
        int numberOfIsland = 0;
        char currentNode = grid[i][j];
        if(currentNode == '1') {
            int[][] dirs = new int[][] {
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
            };
            grid[i][j] = '0';
            numberOfIsland = 1;
            for(int[] dir: dirs) {
                int row = dir[0]+i;
                int column = dir[1]+j;
                if(row>=0&&row<grid.length&&column>=0&&column<grid[0].length&& grid[row][column]=='1') {
                    DFS(grid, row, column);
                }
            }
        }
        return numberOfIsland;
    }

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        char[][] gridTwo = new char[][] { { '0', '1', '0' }, { '1', '0', '1' }, { '0', '1', '0' } };
        char[][] gridThree = new char[][] { { '1','1','1','1','0' }, { '1','1','0','1','0' }, { '1','1','0','0','0'}, { '0','0','0','0','0'}};
        int result = numberOfIsland.numIslandsDFS(gridThree);
        System.out.println("The Number of Island: " + result);
    }
}