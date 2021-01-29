// Time Complexity : o(mn)
// Space Complexity : o(mn)
// Did this code successfully run on Leetcode: Yes
public class NumberOfIslands {

	// dfs
	int m, n;

	public int numIslands(char[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		m = grid.length;
		n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// if it is island check all directions increment count
				if (grid[i][j] == '1') {
					// add count buy one
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int row, int column) {
		// base
		if (row < 0 || row >= m || column < 0 || column >= n || grid[row][column] != '1')
			return;
		// logic
		// change state so we don't encounter same cell again
		grid[row][column] = '2';
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		for (int[] dir : dirs) {
			int r = row + dir[0];
			int c = column + dir[1];
			// dfs on neighbors
			dfs(grid, r, c);
		}
	}
	
	
	// Time Complexity : o(mn)
	// Space Complexity : o(min(m,n))
	// Did this code successfully run on Leetcode: Yes
//    public int numIslands(char[][] grid) {
//    if(grid == null || grid.length == 0) return 0;
//    
//    int m = grid.length;
//    int n= grid[0].length;
//    Queue<Integer> q = new LinkedList<>();
//    int [][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
//    int count = 0;
//    for(int i = 0; i< m; i++){
//        for(int j= 0; j< n; j++) {
//            if(grid[i][j] == '1') {
//                count++;
//                grid[i][j] = '2';
//                q.add(i); q.add(j);
//                while(!q.isEmpty()) {
//                    int cr = q.poll();
//                    int cc = q.poll();
//                    for(int[] dir:dirs) {
//                        int r = cr+dir[0];
//                        int c = cc+dir[1];
//                        if(r>=0 && c>= 0 && r<m && c<n && grid[r][c] == '1') {
//                            grid[r][c] = '2';
//                            q.add(r); q.add(c);
//                        }    
//                    }        
//                }
//            }
//        }
//    }
//    return count;
//}

}
