// TC: O(M*N) where M is number of rows and N is number of columns
// SC : o(M*N) for space where the dfs can deep upto M*N

// We will check if the grid value is 1 and update its adjacent cells to 0(marking them as visited) and update the count of islands, Once we have updated it, it means we have completed one island
// We explore the next part of the grid where we find 1 and update its adjacent cells to 0. Similarly we find all the islands in the grid.
public class numIslands {

	public int numberIslands(char[][] grid) {
		
		int islands = 0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]=='1') {
					islands++;
					dfs(grid, i, j);
				}
			}
		}
		return islands;
	}
	
	public void dfs(char[][] grid, int x, int y) {
		
		if(x<0 || y<0 || x>=grid.length || y>=grid[0].length || grid[x][y]!='1')
			return;
		
		grid[x][y] = '0';
		
		dfs(grid, x-1, y);
		dfs(grid, x+1, y);
		dfs(grid, x, y+1);
		dfs(grid, x, y-1);
		
	}
	
	public static void main(String[] args) {
		
		numIslands ni = new numIslands();
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(ni.numIslands(grid));
	}
}
