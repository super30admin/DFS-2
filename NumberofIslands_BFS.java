
//Tc - O(m*n)
//SC - O(max(m,n))
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<row;i++){
             for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    //add it to queue for processing
                    q.add(new int[]{i,j});
                    //System.out.println(grid[i][j]);
                    grid[i][j]='0';
                    numOfIslands++;
                    //bfs
                    while(!q.isEmpty()){
                        int[] idx = q.poll();
                        for(int[] dir:directions){
                            int nr = dir[0]+idx[0];
                            int nc = dir[1]+idx[1];
                            //bounds check
                            if(nr<0|| nc<0 || nr>=row || nc>=col || grid[nr][nc]=='0' )
                                continue;  //it should go back to for loop
                            else{
                                grid[nr][nc]='0';
                                q.add(new int[]{nr,nc});
                            }
                        }
                    }
                }
             }
        }
        return numOfIslands;
    }
}
public class NumberofIslands_BFS {

	public static void main(String[] args) {
		char[][] grid = {
				  {'1','1','1','1','0'},
				  {'1','1','0','1','0'},
				  {'1','1','0','0','0'},
				  {'0','0','0','0','0'}
				};
		Solution s = new Solution();
		System.out.println(s.numIslands(grid));
	}

}
