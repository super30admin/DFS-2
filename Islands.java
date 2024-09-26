
public class Islands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = new char[][] { { 1, 1, 0, 0, 0 }, 
            { 1, 1, 0, 0, 0 }, 
            { 0, 0, 1, 0, 0 }, 
            { 0, 0, 0, 1, 1 } }; 
			//Islands I = new Islands(); 
            System.out.println(numIslands(grid)); 
	}
	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int count = 0;
        
        for(int i =0; i< grid.length; i++){
            for(int j =0; j < grid[i].length; j++){
                count+=dfs(grid,i,j);
            }
        }
        return count;
    }
    
    private static int dfs(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]!= '1'){
            return 0;
        }
        
        grid[i][j] = '0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;
    }
}
