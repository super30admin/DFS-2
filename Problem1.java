/* Problem1 - Count of Islands */

// Time Complexity : O(mn) in BFS and DFS
// Space Complexity : O(mn) in BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// This problem can be done by both DFS and BFS
// How to understand the pattern if DFS or BFS can be used? If you have dependency across neighbours in a matrix
// DFS- start with first position, keep exploring its child nodes, retrace back and then explore its children until its done
// In DFS, 
// i) create a private function(since its recursive stack we are using)
// ii) under private function(void), first create base case and logic. start with the logic first, call that function considering which arguments change/alter
//     then under 'base case', create the boundation case if it falls out of bounds or if matrix position is 0
// iii) in main function, define edge case for grid/matrix(if its null) or grid/matrix.length == 0
// iv) start iterating over the matrix and validate if it contains 1, so increment count and keep calling that recrusive dfs function
// v) whenever the neighboring element is explored/visited 4 or 8 directions, initialise dirs array
// in BFS, we will initialise a queue and keep adding index in the queue after visiting only when it is 1.
// set that grid index as 0 and start visiting its neighbours by leveraging dirs array.
// at the end return the count(count of islands)

// Exception(by interviewer): if we can't mutate the array(like altering values of 1 to 0 at index after visiting).
// then we have to maintain separate mxn visited array for DFS and BFS elements as visited

/* DFS Solution */
class Solution {
    //global variable
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        m = grid.length;
        //Edge case
        if(grid == null || m == 0) return 0;
        n = grid[0].length;
        //intialise count variable-count of islands
        int count = 0;
        //iterate over the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    //define dfs function
    private void dfs(char[][] grid, int i, int j){
        //base case
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        //logic case
        grid[i][j] = '0';
        //initialising dirs array
        int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        for(int [] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
}


/* BFS Solution 
class Solution {
    //global variable
    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {
        m = grid.length;
        //Edge case
        if(grid == null || m == 0) return 0;
        n = grid[0].length;
        //intialise count variable-count of islands
        int count = 0;
        //initialise dirs array
        int[][] dirs = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};
        //iterate over the matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    //initialise queue
                    Queue<int []> q = new LinkedList<>();
                    //adding index(1) to queue
                    q.add(new int[] {i, j});
                    //now set that grid index to 0
                    grid[i][j] = '0';
                    //now we will iterate over its neighbours 
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int [] dir: dirs){
                            int r = dir[0] + curr[0];
                            int c = dir[1] + curr[1];
                            //adding neighbouring index to queue after processing curr node
                            if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                                q.add(new int[] {r,c});
                                //again set grid index to 0 
                                grid[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}

*/