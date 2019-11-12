/* 
Time complexity: O(mn)
Space complexity: O(mn)
Algorithm:
    - Traverse through the 2D array, if 1 is found. Set that 0 increase count.
    - Perform BFS on that node, Set nearby(4 directions) islands to 0
    - Return count
Did the solution run on leetcode: Yes
Any problems faced: No

*/

class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
       
        if(m==0 || grid==null){
            return 0;
        }
         int n = grid[0].length;
        int count=0;
        int dirs[][] = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                
                if(grid[i][j]=='1'){
                    count++;
                    Queue<int[]> check = new LinkedList<>();
                    check.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while(!check.isEmpty()){
                        int[] curr = check.poll();
                        for(int[] dir: dirs){
                            int r = dir[0]+curr[0];
                            int c = dir[1]+curr[1];
                            if(r>=0&&r<m&&c>=0&&c<n&&grid[r][c]=='1'){
                                grid[r][c] = '0';
                                check.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}