// Time Complexity : O(m*n)
// Space Complexity : O(m*n) - Queue can hold all elements in worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Need to practice. After class, this seems easy


// Your code here along with comments explaining your approach
/*
 * Process Level by Level. Find 1st 1 and then start BFS from there and process level by level. Mark processed 1 to 0 to avoid repeating BFS.
 */


//BFS Apprach

class Solution {
    int count =0;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)  return 0;
        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    q.add(i);
                    q.add(j);
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int ri = q.poll();
                        int ci = q.poll();

                        for(int[] dir : dirs){
                            int nr =  ri + dir[0];
                            int nc =  ci + dir[1];

                            //bounds check - Array Out of Bound Exception Prevention
                            if(nr>=0 && nc>=0 && nr <m && nc<n){
                                if(grid[nr][nc] == '1'){
                                    grid[nr][nc] = '0';
                                    q.add(nr);
                                    q.add(nc);
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
