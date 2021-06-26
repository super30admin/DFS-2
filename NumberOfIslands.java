// Time Complexity : O(M*N)
// Space Complexity :O(M*N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


/*
 * 1. it is BFS approach can be done by using DFS
 * 2. loop through char array and find first char '1'
 * 3. then check make all adjacent '1' to zero and end the BFS.
 * 4. continue the array search for one and increment count if you find '1'
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int count =0;
		
		int[][] arr= new int[][] {{0,-1},{0,1},{-1,0},{1,0}};
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j]== '1') {
					Queue<Integer> queue=new LinkedList<>(); 
					queue.add(i);
					queue.add(j);
							
					while(!queue.isEmpty()) {
						
						int r=queue.poll();
						int c=queue.poll();
						
						for(int k=0;k<arr.length;k++) {
							int nr= r+arr[k][0];
							int nc= c+arr[k][1];
							if(nr>=0 && nr<grid.length&&nc>=0&&nc<grid[0].length && grid[nr][nc]=='1') {
								queue.add(nr);
								queue.add(nc);
								grid[nr][nc]=0;
							}
						}
						
					}
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		char[][] arr= new char[][] {{'1','1','0','0','0'},
			  {'1','1','0','0','0'},
			  {'0','0','1','0','0'},
			  {'0','0','0','1','1'}};
			  
		System.out.println(new NumberOfIslands().numIslands(arr));
	}
}
