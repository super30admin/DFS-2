/* 200. Number of Islands (Depth First Search)

Time Complexity: O(mn)
Space Complexity: O(mn) worst case 
O(mn) in case that the grid map is filled with lands where DFS goes by m*n deep

Treat the 2d grid map as an undirected graph and there is an edge between two horizontally or vertically adjacent nodes of value '1'. if a node contains a '1', then it is a root node that triggers a Depth First Search. During DFS, every visited node should be set as '0' to mark as visited node. Count the number of root nodes that trigger DFS, this number would be the number of islands since each DFS starting at some root identifies an island
*/

class Solution {
    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(grid == null || m==0)
            return 0;

        n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        // called dfs on one cell which had a '1'. now make all neighbors as '0'
        //Base case
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        int[][] dirs = new int[][] {{0,-1}, {0,1}, {-1,0}, {1,0}};
        for(int[] dir: dirs){
            int r = dir[0] + i;
            int c = dir[1] + j;
            dfs(grid, r, c);
        }
    }
}

/* 200. Number of Islands (Breadth First Search)

Time Complexity: O(mn)
Space Complexity: O(mn)

Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Breadth First Search. Put it into a queue and set its value as '0' to mark as visited node. Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
*/

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(grid == null || m==0)
            return 0;
        int n = grid[0].length;
        int[][] dirs = new int[][] {{0,-1},{0,1},{1,0}, {-1,0}};

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int cur[] = q.poll();

                        for(int[] dir : dirs){
                            int r = dir[0] + cur[0];
                            int c = dir[1] + cur[1];

                            if(r>=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                                q.add(new int[]{r,c});
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