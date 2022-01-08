// Time Complexity : O(n*m)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// Make a recursive call for the neighbouting part and for every value of array, check for the land first.
// Your code here along with comments explaining your approach
// dfs
class Solution {
    int m;
    int n;
    int [][] dirs;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int count  = 0;
        dirs = new int [][] {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < m; i++){
            for(int j  = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char [][] grid, int i, int j){
        //base
        if( i == m || j == n || i < 0 || j < 0 || grid[i][j] == '0') return;
        //logic
        grid[i][j] = '0';
        for(int [] dir: dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(grid, r, c);
        }
    }
}

// Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// using stack store the visited index and go over its neighbour if found 1 and make it visited by setting it 0, increase the count only when call from the start.
// Your code here along with comments explaining your approach
// bfs
// class Solution {
//     public int numIslands(char[][] grid) {
//         if(grid == null || grid.length == 0) return 0;
//         int m = grid.length;
//         int n = grid[0].length;
//         int [][] dirs = new int [][] {{0,1},{1,0},{-1,0},{0,-1}};
//         int count = 0;
//         Queue<int []> q = new LinkedList<>();
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == '1'){
//                     count++;
//                     grid[i][j] = '0';
//                     q.add(new int [] {i,j});
//                     while(!q.isEmpty()){
//                         int [] curr = q.poll();
//                         for(int [] dir : dirs){
//                             int r = dir[0] + curr[0];
//                             int c = dir[1] + curr[1];
//                             if(r < m && c < n && r >=0 && c >=0 && grid[r][c] == '1'){
//                                 grid[r][c] = '0';
//                                 q.add(new int [] {r,c});
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return count;

//     }
// }