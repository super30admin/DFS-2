// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                char item = grid[i][j];
                if(item == '1'){
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';
                    count++;
                }

                while(!q.isEmpty()){
                    int[] polled = q.poll();

                    // up
                    if(polled[0] > 0){
                        if(grid[polled[0]-1][polled[1]] == '1'){
                            q.add(new int[]{polled[0]-1, polled[1]});
                            grid[polled[0]-1][polled[1]] = '0';
                        }
                    }

                    // down
                    if(polled[0]+1 < grid.length){
                        if(grid[polled[0]+1][polled[1]] == '1'){
                            q.add(new int[]{polled[0]+1, polled[1]});
                            grid[polled[0]+1][polled[1]] = '0';
                        }
                    }

                    // left
                    if(polled[1] > 0){
                        if(grid[polled[0]][polled[1]-1] == '1'){
                            q.add(new int[]{polled[0], polled[1]-1});
                            grid[polled[0]][polled[1]-1] = '0';  
                        }
                    }

                    // right
                    if(polled[1]+1 < grid[i].length){
                        if(grid[polled[0]][polled[1]+1] == '1'){
                            q.add(new int[]{polled[0], polled[1]+1});
                            grid[polled[0]][polled[1]+1] = '0';  
                        }
                    }
                }
                
            }
        }

        return count;
    }
}
