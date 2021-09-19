// Time Complexity: As we are maintaining visited by updating the 1 to 0 on first dfs itself, it is not explored in any further traversal O(m*n)
// Space Complexity: additional datastructure used (queue)of size O(m*n)
// Did you complete it on leetcode: Yes
// Any problems faced: No

// Write your approach:
// Idea here is to traverse each cell and apply bfs in optimal way, where if a 1 is found,
// we explore that cells all neighbours and assign current cell value to 0
// so that it is not explored through any other way.
// we poll each cell index and check neighbours, if they are in bounds and value = 1 we add them to queue and set value to 0
// we increase island count with 1. We keep exploring any following 1 and increasing count
// final count is returned.
class Solution {
    int m; int n;
    int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        m = grid.length;
        if(m==0) return 0;
        n = grid[0].length;
        int islandCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j]=='1') {
                    grid[i][j] = 0;
                    q.add(new int[]{i,j});
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for(int t=0; t< size; t++) {
                            int[] curr = q.poll();
                            for(int[] dir: dirs) {
                                int r = curr[0] + dir[0];
                                int c = curr[1] + dir[1];
                                if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1') {
                                    grid[r][c] = 0;
                                    q.add(new int[]{r,c});
                                }
                            }
                        }
                    }
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
}