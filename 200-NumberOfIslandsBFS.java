/**LC-200
 * Time Complexity : O2(MN) = O(MN)
 * Space Complexity : O(MN) 
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 Algorithm:
Here to restore the original state we can convert the 1s to 2s instead of 0's and at the end of BFS we can convert all the 2's to the 1's.
1. We start iterating over each element in the matrix.
2. When we encounter a 1, we will perform a BFS on it.
 3. if curr element is 1, add to stack AND convert it to 0
    4. while the q is not empty,
       5. we check all the dirs of the element we got from the indices we got from poll().
    6. increment count
7. return count

 */
class Solution {
    public int numIslands(char[][] grid) {
        
        //edge
        if(grid == null || grid.length == 0) return 0;
    
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList();
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){
                
                if(grid[i][j] == '1'){
                    
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                       for(int[] dir: dirs){
                        
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        
                        if(r >=0 && r<m && c>=0 && c<n && grid[r][c] == '1'){
                            grid[r][c] = '0';
                            q.add(new int[]{r, c});
                        }
                    } 
                    }
                    count++;
                }
            }
        }
        return count;
    }
}