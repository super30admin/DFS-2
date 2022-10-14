/*approach - BFS
 * 1.take length of matrix, row and col
 * 2. take count variable
 * 3. start scanning the matrix and look for grid ==1
 * 4. when we find it - increment count by 1, mark that grid as 0 so it wont get pushed again
 * 5. start a bfs there, take a queue. push those cordinates to queue.
 * 6. check nr and nc neighbors - and push them to queue if they are 1, also change them to 0. 
 * at last return count.  
 * 
 * SC - we dont create any adjaceny list here which is E. so SC  is minimum of O(v, E) - as at a time there will be 
 * at max 4 neighbors depending on if v is minimum or edges. ex just (1 row -  1 1 1 1 )or (1 col 1 1 1 1)
 * TC - O(mn) + O(mn) = 2O(mn) = O(mn)
 */
//


class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int count =0;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        for(int i =0; i< m; i++)
        {
            for(int j=0; j< n ; j++)
            {
                if(grid[i][j] == '1')
                {
                    count++;
                    grid[i][j] = '0';
                
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i,j}); 
                    while(!q.isEmpty())
                    {
                        int[] curr = q.poll();
                        
                        for(int[] dir : dirs)
                        {
                            int nr = dir[0]+curr[0];
                            int nc = dir[1] +curr[1];
                            
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1')
                            {
                                grid[nr][nc] = '0';
                                q.add(new int[] {nr,nc});
                            }
                        }
                    }
                }
            }
        }
        return count;
        
    }
}