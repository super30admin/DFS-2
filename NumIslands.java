// Time Complexity :O(mn) in both BFS and DFS
// Space Complexity :O(mn) in Bfs as we have to maintain the queue
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

// DFS/recursive approach

// Here we go at each i and j and run the helper function 
// in the helper function  we see if that element has 1 if no return false (i.e no islands)
// if the element is 1 then we go to helper(neighbouring elements) and return true after everything

// number of times we get true for the dfs we count++

// alternatively you can mask the 1s with -1s and do dfs only if has -1s and not 1s
// this masking with -1 or turning into 0s is done so that it doesnt get caught in a loop

class Solution {
    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0)
            return 0;

        int c = grid[0].length;

        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (helper(i, j, grid))
                    count++;
            }
        }
        return count;
    }

    private boolean helper(int i, int j, char grid[][]) {
        int row = grid.length;
        int col = grid[0].length;
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1')
            return false;

        grid[i][j] = 0;

        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(r, c, grid);
        }

        return true;

    }
}

/////////////////////////////////////////////// BFS approach
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// we add x and ys of all the 0s to the queue

class Solution {
    int dirs[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int numIslands(char[][] grid) {
        int r = grid.length;
        if (r == 0)
            return 0;

        int c = grid[0].length;
        int dirs[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] { i, j });
                    count++;
                    helper(q, grid);
                }
            }
        }

        return count;
    }

    private void helper(Queue<int[]> q, char[][] grid) {
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                if (grid[temp[0]][temp[1]] == '1') {
                    grid[temp[0]][temp[1]] = '0';
                    for (int dir[] : dirs) {
                        int r = dir[0] + temp[0];
                        int c = dir[1] + temp[1];
                        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == '1')
                            q.add(new int[] { r, c });
                    }
                }

            }

        }

    }

}