// Time Complexity : O(2mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We will iterate over the grid, whenever we find 1 we will do BFS and once BFS is complete , we will increment the count
class Solution {
    // Time Complexity O( 2mn) // If all of the elements are 1 s
    public int numIslands(char[][] grid) {

        

        int count =0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> queue = new LinkedList<int[]>();

        int m  = grid.length;
        int n = grid[0].length;
            // M * N
        for(int r = 0;r<m;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c] == '1'){
                    count++;
                    grid[r][c] = '0' ; // make it 0 and push into the queue
                    queue.add(new int[]{r,c}); 
                    //now do BFS
                    while(!queue.isEmpty()){ // M * N
                        int[] current = queue.poll();
                        for(int[] cord : dirs){
                            int nr = cord[0] + current[0];
                            int nc = cord[1] + current[1];
                            if(!(nr < 0 || nr >=grid.length || nc <0 || nc >= grid[0].length) && grid[nr][nc] != '0'){
                                // mark it and add it to the queue
                                grid[nr][nc] = '0'; // making it zero so that we dont visit it again
                                queue.add(new int[]{nr,nc});
                            }
                        }

                    }

                }
            }

        }

        return count;
        
    }
}